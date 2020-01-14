package pl.coderslab.charity.factories;

import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitialDataFactory {
    public static List<Institution> createInstitutions() {
        /*
        Fundacja "Dbam o Zdrowie"
Cel i misja: Pomoc dzieciom z ubogich rodzin.
Fundacja "A kogo"
Cel i misja: Pomoc wybudzaniu dzieci ze śpiączki.
Fundacja “Dla dzieci"
Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji życiowej.
Fundacja “Bez domu”
Cel i misja: Pomoc dla osób nie posiadających miejsca zamieszkania
         */
        List<Institution> institutions= Arrays.asList(
                Institution.builder().name("Dbam o Zdrowie").description("Pomoc dzieciom z ubogich rodzin").build(),
                Institution.builder().name("A kogo").description("Pomoc wybudzaniu dzieci ze śpiączki").build(),
                Institution.builder().name("Dla dzieci").description("Pomoc osobom znajdującym się w trudnej sytuacji życiowej").build(),
                Institution.builder().name("Bez domu").description("Pomoc dla osób nie posiadających miejsca zamieszkania").build(),
                Institution.builder().name("Szlachetna paczka").description("Pomoc ubogim rodzinom, dzieciom, seniorom i chorym").build()
        );
        return institutions;
    }
    public static List<Category> createCategories() {
        List<Category> categories = Arrays.asList(
                Category.builder().name("ubrania, które nadają się do ponownego użycia").build(),
                Category.builder().name("ubrania, do wyrzucenia").build(),
                Category.builder().name("zabawki").build(),
                Category.builder().name("książki").build(),
                Category.builder().name("inne").build()
        );
        return categories;
    }
    public static List<Donation> createDonations() {
        List<Institution> institutions=createInstitutions();
        List<Category> categories=createCategories();
        List<Donation> donations = new ArrayList<>();
        for (Institution institution:institutions) {
                    donations.add( Donation.builder().institution(institution).categories(categories).quantity(2).build());
        }
        return donations;
    }
}
