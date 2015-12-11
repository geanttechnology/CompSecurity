.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/message/LineParser;
.super Ljava/lang/Object;
.source "LineParser.java"


# virtual methods
.method public abstract hasProtocolVersion(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)Z
.end method

.method public abstract parseHeader(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)Lcom/comcast/cim/httpcomponentsandroid/Header;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ParseException;
        }
    .end annotation
.end method

.method public abstract parseRequestLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)Lcom/comcast/cim/httpcomponentsandroid/RequestLine;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ParseException;
        }
    .end annotation
.end method

.method public abstract parseStatusLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)Lcom/comcast/cim/httpcomponentsandroid/StatusLine;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ParseException;
        }
    .end annotation
.end method
