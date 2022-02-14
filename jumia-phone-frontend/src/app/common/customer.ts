export interface Customer {
    name:    string;
    phone:   string;
    contact: Contact;
}

export interface Contact {
    country:     string;
    state:       string;
    countryCode: string;
    number:      string;
}

export enum Country {
    Camaroon = "Camaroon",
    Ethiopia = "Ethiopia",
    Morocco = "Morocco",
    Mozambique = "Mozambique",
    Uganda = "Uganda",
}

export enum State {
    NotValid = "Not Valid",
    Valid = "Valid",
}
