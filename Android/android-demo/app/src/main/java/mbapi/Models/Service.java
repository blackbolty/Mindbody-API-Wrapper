package mbapi.Models;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Date;
import mbapi.Helper.Utility;

public class Service
{
    public int Count;
    public int Remaining;
    public String TaxRate;
    public String Price;
    public String OnlinePrice;
    public Date PaymentDate;
    public Date ActiveDate;
    public Date ExpirationDate;
    public Boolean Current;
    public String ID;
    public String Name;

    public static Service Parse(Node n)
    {
        NodeList properties = n.getChildNodes();

        Service obj = new Service();
        for (int i = 0; i < properties.getLength(); i++)
        {
            Node node = properties.item(i);
            String field = node.getNodeName();

            if (field.equals("Current") && !node.hasAttributes()) obj.Current = Boolean.parseBoolean(node.getTextContent());
            else if (field.equals("TaxRate") && !node.hasAttributes()) obj.TaxRate = node.getTextContent();
            else if (field.equals("Price") && !node.hasAttributes()) obj.Price = node.getTextContent();
            else if (field.equals("ID") && !node.hasAttributes()) obj.ID = node.getTextContent();
            else if (field.equals("Name") && !node.hasAttributes()) obj.Name = node.getTextContent();
            else if (field.equals("OnlinePrice") && !node.hasAttributes()) obj.OnlinePrice = node.getTextContent();
            else if (field.equals("PaymentDate") && !node.hasAttributes()) obj.PaymentDate = Utility.getDateFromISO(node.getTextContent());
            else if (field.equals("ActiveDate") && !node.hasAttributes()) obj.ActiveDate = Utility.getDateFromISO(node.getTextContent());
            else if (field.equals("ExpirationDate") && !node.hasAttributes()) obj.ExpirationDate = Utility.getDateFromISO(node.getTextContent());
            else if (field.equals("Count") && !node.hasAttributes()) obj.Count = Integer.parseInt(node.getTextContent());
            else if (field.equals("Remaining") && !node.hasAttributes()) obj.Remaining = Integer.parseInt(node.getTextContent());

        }
        return obj;
    }
}
