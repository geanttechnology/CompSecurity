.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;
.super Ljava/lang/Object;
.source "HttpMessage.java"


# virtual methods
.method public abstract addHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V
.end method

.method public abstract addHeader(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract containsHeader(Ljava/lang/String;)Z
.end method

.method public abstract getAllHeaders()[Lcom/comcast/cim/httpcomponentsandroid/Header;
.end method

.method public abstract getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;
.end method

.method public abstract getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;
.end method

.method public abstract getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
.end method

.method public abstract getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
.end method

.method public abstract headerIterator()Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;
.end method

.method public abstract headerIterator(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;
.end method

.method public abstract removeHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V
.end method

.method public abstract removeHeaders(Ljava/lang/String;)V
.end method

.method public abstract setHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V
.end method

.method public abstract setHeader(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract setHeaders([Lcom/comcast/cim/httpcomponentsandroid/Header;)V
.end method

.method public abstract setParams(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
.end method
