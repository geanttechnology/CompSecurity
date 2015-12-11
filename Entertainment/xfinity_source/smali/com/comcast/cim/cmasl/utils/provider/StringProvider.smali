.class public Lcom/comcast/cim/cmasl/utils/provider/StringProvider;
.super Ljava/lang/Object;
.source "StringProvider.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/utils/provider/Provider",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field private final string:Ljava/lang/String;


# virtual methods
.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 3
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/utils/provider/StringProvider;->get()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public get()Ljava/lang/String;
    .locals 1

    .prologue
    .line 12
    iget-object v0, p0, Lcom/comcast/cim/cmasl/utils/provider/StringProvider;->string:Ljava/lang/String;

    return-object v0
.end method
