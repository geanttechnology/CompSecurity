.class public final Lcom/damnhandy/uri/template/impl/VarExploderFactory;
.super Ljava/lang/Object;
.source "VarExploderFactory.java"


# direct methods
.method public static getExploder(Ljava/lang/Object;Lcom/damnhandy/uri/template/impl/VarSpec;)Lcom/damnhandy/uri/template/VarExploder;
    .locals 1
    .param p0, "varValue"    # Ljava/lang/Object;
    .param p1, "varSpec"    # Lcom/damnhandy/uri/template/impl/VarSpec;

    .prologue
    .line 31
    instance-of v0, p0, Lcom/damnhandy/uri/template/VarExploder;

    if-eqz v0, :cond_0

    .line 33
    check-cast p0, Lcom/damnhandy/uri/template/VarExploder;

    .line 41
    .end local p0    # "varValue":Ljava/lang/Object;
    :goto_0
    return-object p0

    .restart local p0    # "varValue":Ljava/lang/Object;
    :cond_0
    new-instance v0, Lcom/damnhandy/uri/template/DefaultVarExploder;

    invoke-direct {v0, p0}, Lcom/damnhandy/uri/template/DefaultVarExploder;-><init>(Ljava/lang/Object;)V

    move-object p0, v0

    goto :goto_0
.end method
