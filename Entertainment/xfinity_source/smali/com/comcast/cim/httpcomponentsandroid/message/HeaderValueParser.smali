.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/message/HeaderValueParser;
.super Ljava/lang/Object;
.source "HeaderValueParser.java"


# virtual methods
.method public abstract parseElements(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ParseException;
        }
    .end annotation
.end method

.method public abstract parseHeaderElement(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ParseException;
        }
    .end annotation
.end method
