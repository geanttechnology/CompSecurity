.class public Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;
.super Ljava/lang/Object;
.source "AppTrackable.java"

# interfaces
.implements Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;


# instance fields
.field private contextData:Ljava/util/Hashtable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Hashtable",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private evars:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lorg/apache/http/message/BasicNameValuePair;",
            ">;"
        }
    .end annotation
.end field

.field private events:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private name:Ljava/lang/String;

.field private props:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lorg/apache/http/message/BasicNameValuePair;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    const-string v0, "TRACKER"

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->name:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public addContext(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 41
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->contextData:Ljava/util/Hashtable;

    if-nez v0, :cond_0

    .line 42
    new-instance v0, Ljava/util/Hashtable;

    invoke-direct {v0}, Ljava/util/Hashtable;-><init>()V

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->contextData:Ljava/util/Hashtable;

    .line 44
    :cond_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->contextData:Ljava/util/Hashtable;

    invoke-virtual {v0, p1, p2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 45
    return-void
.end method

.method public addEvar(ILjava/lang/String;)V
    .locals 4
    .param p1, "evar"    # I
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 63
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->evars:Ljava/util/ArrayList;

    if-nez v0, :cond_0

    .line 64
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->evars:Ljava/util/ArrayList;

    .line 66
    :cond_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->evars:Ljava/util/ArrayList;

    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, p2}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 67
    return-void
.end method

.method public addEvent(Ljava/lang/String;)V
    .locals 1
    .param p1, "event"    # Ljava/lang/String;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->events:Ljava/util/ArrayList;

    if-nez v0, :cond_0

    .line 19
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->events:Ljava/util/ArrayList;

    .line 21
    :cond_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->events:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 22
    return-void
.end method

.method public addProp(ILjava/lang/String;)V
    .locals 4
    .param p1, "prop"    # I
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->props:Ljava/util/ArrayList;

    if-nez v0, :cond_0

    .line 55
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->props:Ljava/util/ArrayList;

    .line 57
    :cond_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->props:Ljava/util/ArrayList;

    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, p2}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 59
    return-void
.end method

.method public getContextData()Ljava/util/Hashtable;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Hashtable",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 26
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->contextData:Ljava/util/Hashtable;

    return-object v0
.end method

.method public bridge synthetic getContextData()Ljava/util/Map;
    .locals 1

    .prologue
    .line 8
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->getContextData()Ljava/util/Hashtable;

    move-result-object v0

    return-object v0
.end method

.method public getEvars()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lorg/apache/http/message/BasicNameValuePair;",
            ">;"
        }
    .end annotation

    .prologue
    .line 36
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->evars:Ljava/util/ArrayList;

    return-object v0
.end method

.method public bridge synthetic getEvars()Ljava/util/List;
    .locals 1

    .prologue
    .line 8
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->getEvars()Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public getEvents()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 31
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->events:Ljava/util/ArrayList;

    return-object v0
.end method

.method public bridge synthetic getEvents()Ljava/util/List;
    .locals 1

    .prologue
    .line 8
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->getEvents()Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getProps()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lorg/apache/http/message/BasicNameValuePair;",
            ">;"
        }
    .end annotation

    .prologue
    .line 49
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->props:Ljava/util/ArrayList;

    return-object v0
.end method

.method public bridge synthetic getProps()Ljava/util/List;
    .locals 1

    .prologue
    .line 8
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->getProps()Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 71
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->name:Ljava/lang/String;

    .line 72
    return-void
.end method
