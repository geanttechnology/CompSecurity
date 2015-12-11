.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/Header;
.super Ljava/lang/Object;
.source "Header.java"


# virtual methods
.method public abstract getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ParseException;
        }
    .end annotation
.end method

.method public abstract getName()Ljava/lang/String;
.end method

.method public abstract getValue()Ljava/lang/String;
.end method
