.class public abstract Lcom/comcast/cim/httpcomponentsandroid/params/AbstractHttpParams;
.super Ljava/lang/Object;
.source "AbstractHttpParams.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;


# direct methods
.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    return-void
.end method


# virtual methods
.method public getBooleanParameter(Ljava/lang/String;Z)Z
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "defaultValue"    # Z

    .prologue
    .line 88
    invoke-virtual {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/AbstractHttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 89
    .local v0, "param":Ljava/lang/Object;
    if-nez v0, :cond_0

    .line 92
    .end local v0    # "param":Ljava/lang/Object;
    .end local p2    # "defaultValue":Z
    :goto_0
    return p2

    .restart local v0    # "param":Ljava/lang/Object;
    .restart local p2    # "defaultValue":Z
    :cond_0
    check-cast v0, Ljava/lang/Boolean;

    .end local v0    # "param":Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result p2

    goto :goto_0
.end method

.method public getIntParameter(Ljava/lang/String;I)I
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "defaultValue"    # I

    .prologue
    .line 62
    invoke-virtual {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/AbstractHttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 63
    .local v0, "param":Ljava/lang/Object;
    if-nez v0, :cond_0

    .line 66
    .end local v0    # "param":Ljava/lang/Object;
    .end local p2    # "defaultValue":I
    :goto_0
    return p2

    .restart local v0    # "param":Ljava/lang/Object;
    .restart local p2    # "defaultValue":I
    :cond_0
    check-cast v0, Ljava/lang/Integer;

    .end local v0    # "param":Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result p2

    goto :goto_0
.end method

.method public isParameterFalse(Ljava/lang/String;)Z
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 105
    invoke-virtual {p0, p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/params/AbstractHttpParams;->getBooleanParameter(Ljava/lang/String;Z)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v0, 0x1

    :cond_0
    return v0
.end method

.method public isParameterTrue(Ljava/lang/String;)Z
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 101
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/params/AbstractHttpParams;->getBooleanParameter(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public setBooleanParameter(Ljava/lang/String;Z)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Z

    .prologue
    .line 96
    if-eqz p2, :cond_0

    sget-object v0, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    :goto_0
    invoke-virtual {p0, p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/params/AbstractHttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 97
    return-object p0

    .line 96
    :cond_0
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    goto :goto_0
.end method

.method public setIntParameter(Ljava/lang/String;I)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # I

    .prologue
    .line 70
    new-instance v0, Ljava/lang/Integer;

    invoke-direct {v0, p2}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {p0, p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/params/AbstractHttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 71
    return-object p0
.end method

.method public setLongParameter(Ljava/lang/String;J)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # J

    .prologue
    .line 57
    new-instance v0, Ljava/lang/Long;

    invoke-direct {v0, p2, p3}, Ljava/lang/Long;-><init>(J)V

    invoke-virtual {p0, p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/params/AbstractHttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 58
    return-object p0
.end method
