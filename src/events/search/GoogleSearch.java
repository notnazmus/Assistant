package search;
import javafx.scene.image.Image;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;


public class GoogleSearch {

    private static String questionType;

    private  static Image[] img;

    private  static  String answer;

    private  String query;



    public GoogleSearch()
    {
    }

    public static String basicSearch(String query) throws IOException
    {
        String answer;
        Document doc = Jsoup.connect("https://www.google.com/search?q=" + query).get();

        if (query.toLowerCase().contains("lyrics"))
        {
            answer = getLyrics(doc);
            if (answer != null)
                return answer;
        }

        answer = searchOne(doc);
        if (answer != null)
            return answer;

        answer = definitionSearch(doc);
        if (answer != null)
            return answer;

        answer = searchTwo(doc);
        if (answer != null)
            return answer;

        answer = carouselSearch(doc);
        if (answer != null)
            return answer;

        answer = searchThree(doc);
        if (answer != null)
            return answer;

        answer = getWeather(doc);
        if (answer != null)
            return answer;

        answer =  getLinks(doc);

        return answer;
    }


    public static String searchOne(Document document)
    {
        String answer;
        Elements Z0LcW = document.select("div.Z0LcW");
        Elements i4J0ge = document.select("div.i4J0ge");
        Elements xpdclps = document.select("div.xpdclps.mod");
        if ( Z0LcW.size() != 0)
        {
            answer =  Z0LcW.get(0).text();
            if (xpdclps.size() > 0)
            {
                for (Element e: xpdclps)
                {
                    answer += "\n" + e.text();
                }
            } else {
                if (i4J0ge.size() > 0)
                {
                    for (Element e: i4J0ge)
                    {
                        answer += "\n" + e.text();
                    }
                }
            }

        }
        else
            answer = null;

        return  answer;
    }

    public static String searchTwo(Document document)
    {
        String answer;
        Elements LGOjhe = document.select("div.LGOjhe");
        if ( LGOjhe.size() != 0)
            answer =  LGOjhe.get(0).text();
        else
            answer = null;

        return answer;
    }

    public static String searchThree(Document document)
    {
        String answer = "";
        Elements i4J0ge = document.select("div.i4J0ge");
            if ( i4J0ge.size() != 0)
                answer =  i4J0ge.get(0).text();
            else
                answer = null;
        return answer;
    }

    public static String getLyrics(Document document)
    {
        String answer = "";

        Element Kvw2ac = document.selectFirst("div.Kvw2ac");
        Elements span = Kvw2ac.select("span");
        //System.out.println(span.size());
        if ( span.size() != 0)
        {
            for (Element e: span)
            {
               String jsname = e.attr("jsname");
               if (jsname.equals("YS01Ge"))
               {

                   answer += e.text() + "\n";
               }
            }
        }
        else
            answer = null;


        return answer;
    }

    public static String definitionSearch(Document document)
    {
        String answer ="";
        Elements lr_dct_sf_sen = document.select("div.lr_dct_sf_sen");
        Elements lr_dct_sf_h = document.select("div.lr_dct_sf_h");
        Elements vmod = document.select("div.vmod");
        if ( lr_dct_sf_sen.size() != 0)
        {
            for (int i=0, n=0; i < lr_dct_sf_sen.size(); i++)
            {
                if (vmod.text().indexOf(lr_dct_sf_h.get(n).text()) < vmod.text().indexOf(lr_dct_sf_sen.get(i).text()))
                {
                    answer +=  lr_dct_sf_h.get(n).text() + "\n" ;
                    n++;
                }
                answer +=  lr_dct_sf_sen.get(i).text() +"\n";
            }
        }
        else
            answer = null;

        return answer;
    }

    public static String carouselSearch(Document document)
    {
        String answer = "";
        Elements TZNJBf = document.select("div.TZNJBf");
        if (TZNJBf.size() >0)
        {
            for (Element e : TZNJBf)
            {
                answer += " - "+e.text() +"\n";
            }

            return answer;
        }else
            return null;
    }

    public static String getWeather(Document document)
    {
        String answer = "";
        Elements temp = document.select("span.wob_t");
        if (temp.size()>0)
        {
            answer += document.select("div.vk_gy.vk_h").get(0).text()+"\n";
            answer += document.select("div.vk_gy.vk_sh").get(0).text()+"\n";
            answer += "The Temperature is: "+temp.get(0).text() + "°F \n";
            answer += document.select("span.vk_gy.vk_sh").get(0).text() +"\n";
            String str = document.select("div.vk_gy.vk_sh.wob-dtl").get(0).text()+ "\n";
            str = str.substring(0, str.indexOf("mph")+3);
            answer += str;

            return  answer;

        } else
            return null;
    }

    public static String getLinks(Document document)
    {
        String answer = "";

        Elements links = document.select("div.r").select("a[href]");
        for (Element e : links)
        {
            answer += e.text().replace("Cached","").replace("Similar","") + "\n";
        }
        return  answer;
    }







    public static void main(String[] args) throws IOException
    {
        GoogleSearch search = new GoogleSearch();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        for (int i =1; i > 0; i++)
        {
            System.out.println("Enter Your Search Query");
            input = scanner.nextLine();
            System.out.println( "\n" + search.basicSearch(input)+"\n");
        }




    }

}