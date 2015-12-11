.class public Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;
.super Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;
.source "SourceFile"


# instance fields
.field private agent:Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;

.field private shipToStore:Z

.field private storeId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/Fulfillment;-><init>()V

    return-void
.end method

.method public static loadData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;)Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;
    .locals 1

    .prologue
    .line 34
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;-><init>()V

    .line 35
    iput-object p0, v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;->itemId:Ljava/lang/String;

    .line 36
    iput-object p1, v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;->ffId:Ljava/lang/String;

    .line 37
    iput-object p2, v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;->storeId:Ljava/lang/String;

    .line 38
    iput-boolean p3, v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;->shipToStore:Z

    .line 39
    iput-object p4, v0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;->agent:Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;

    .line 40
    return-object v0
.end method

.method public static loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 44
    new-instance v2, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;-><init>()V

    .line 45
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getAttributes()Lorg/w3c/dom/NamedNodeMap;

    move-result-object v0

    .line 46
    const-string v3, "store-id"

    invoke-interface {v0, v3}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v3

    invoke-interface {v3}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;->storeId:Ljava/lang/String;

    .line 47
    const-string v3, "item-id"

    invoke-interface {v0, v3}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v3

    invoke-interface {v3}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;->itemId:Ljava/lang/String;

    .line 48
    const-string v3, "item-id"

    invoke-interface {v0, v3}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v0

    invoke-interface {v0}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v0

    const-string v3, "true"

    invoke-virtual {v0, v3}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, v2, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;->shipToStore:Z

    .line 49
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 50
    :goto_1
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v3

    if-ge v1, v3, :cond_0

    .line 51
    invoke-interface {v0, v1}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v3

    .line 52
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "friends-family-details"

    invoke-virtual {v4, v5}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v4

    if-nez v4, :cond_2

    .line 53
    invoke-static {v3}, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;->agent:Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;

    .line 57
    :cond_0
    return-object v2

    :cond_1
    move v0, v1

    .line 48
    goto :goto_0

    .line 50
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1
.end method


# virtual methods
.method public getAgent()Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;->agent:Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;

    return-object v0
.end method

.method public getStoreId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;->storeId:Ljava/lang/String;

    return-object v0
.end method

.method public getXML()Ljava/lang/String;
    .locals 2

    .prologue
    .line 62
    const-string v0, ""

    .line 63
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<store-fulfillment store-id=\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;->storeId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\" item-id=\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;->itemId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\" ship-to-store=\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;->shipToStore:Z

    if-eqz v0, :cond_1

    const-string v0, "true"

    :goto_0
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\">"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 64
    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;->agent:Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;

    if-eqz v1, :cond_0

    .line 65
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<friends-family-details><firstname>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;->agent:Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->getFirstName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</firstname>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<lastname>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;->agent:Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->getLastName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</lastname>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<emailaddress>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;->agent:Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->getEmail()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</emailaddress>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<phonenumber>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;->agent:Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->getPhoneNumber()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</phonenumber>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</friends-family-details>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 72
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</store-fulfillment>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 74
    return-object v0

    .line 63
    :cond_1
    const-string v0, "false"

    goto/16 :goto_0
.end method

.method public isShipToStore()Z
    .locals 1

    .prologue
    .line 26
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/fulfillment/FulfillmentStore;->shipToStore:Z

    return v0
.end method
