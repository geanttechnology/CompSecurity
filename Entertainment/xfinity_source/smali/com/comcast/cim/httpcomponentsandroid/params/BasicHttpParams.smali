.class public Lcom/comcast/cim/httpcomponentsandroid/params/BasicHttpParams;
.super Lcom/comcast/cim/httpcomponentsandroid/params/AbstractHttpParams;
.source "BasicHttpParams.java"

# interfaces
.implements Ljava/io/Serializable;
.implements Ljava/lang/Cloneable;


# instance fields
.field private final parameters:Ljava/util/HashMap;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 53
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/params/AbstractHttpParams;-><init>()V

    .line 50
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/params/BasicHttpParams;->parameters:Ljava/util/HashMap;

    .line 54
    return-void
.end method


# virtual methods
.method public clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 146
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/params/BasicHttpParams;

    .line 147
    .local v0, "clone":Lcom/comcast/cim/httpcomponentsandroid/params/BasicHttpParams;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/params/BasicHttpParams;->copyParams(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 148
    return-object v0
.end method

.method protected copyParams(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 4
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 152
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/params/BasicHttpParams;->parameters:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 153
    .local v0, "iter":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 154
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 155
    .local v1, "me":Ljava/util/Map$Entry;
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    instance-of v2, v2, Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 156
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    invoke-interface {p1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    goto :goto_0

    .line 158
    .end local v1    # "me":Ljava/util/Map$Entry;
    :cond_1
    return-void
.end method

.method public getParameter(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/params/BasicHttpParams;->parameters:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 61
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/params/BasicHttpParams;->parameters:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 62
    return-object p0
.end method
