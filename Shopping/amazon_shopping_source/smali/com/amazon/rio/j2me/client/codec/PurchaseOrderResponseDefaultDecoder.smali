.class public Lcom/amazon/rio/j2me/client/codec/PurchaseOrderResponseDefaultDecoder;
.super Ljava/lang/Object;
.source "PurchaseOrderResponseDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;
    .locals 18
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "ignored"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 21
    new-instance v13, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;

    invoke-direct {v13}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;-><init>()V

    .line 26
    .local v13, "record":Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;
    invoke-virtual/range {p1 .. p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v12

    .line 27
    .local v12, "isAbsent":Z
    if-nez v12, :cond_0

    .line 29
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v14

    invoke-static {v14}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v14

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-interface {v14, v0, v15}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/util/List;

    .line 30
    .local v11, "data":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {v13, v11}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->setError(Ljava/util/List;)V

    .line 33
    .end local v11    # "data":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_0
    invoke-virtual/range {p1 .. p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v12

    .line 34
    if-nez v12, :cond_1

    .line 36
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v14

    invoke-static {v14}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v14

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-interface {v14, v0, v15}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/util/List;

    .line 37
    .restart local v11    # "data":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {v13, v11}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->setInfo(Ljava/util/List;)V

    .line 40
    .end local v11    # "data":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_1
    invoke-virtual/range {p1 .. p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v12

    .line 41
    if-nez v12, :cond_2

    .line 43
    new-instance v14, Lcom/amazon/rio/j2me/client/codec/RichMessageDefaultDecoder;

    invoke-direct {v14}, Lcom/amazon/rio/j2me/client/codec/RichMessageDefaultDecoder;-><init>()V

    invoke-static {v14}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v14

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-interface {v14, v0, v15}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/util/List;

    .line 44
    .local v10, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;>;"
    invoke-virtual {v13, v10}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->setPurchaseMessages(Ljava/util/List;)V

    .line 47
    .end local v10    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;>;"
    :cond_2
    invoke-virtual/range {p1 .. p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v12

    .line 48
    if-nez v12, :cond_3

    .line 50
    new-instance v14, Lcom/amazon/rio/j2me/client/codec/PurchaseStatusDefaultDecoder;

    invoke-direct {v14}, Lcom/amazon/rio/j2me/client/codec/PurchaseStatusDefaultDecoder;-><init>()V

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v14, v0, v15}, Lcom/amazon/rio/j2me/client/codec/PurchaseStatusDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/PurchaseStatus;

    move-result-object v1

    .line 51
    .local v1, "data":Lcom/amazon/rio/j2me/client/services/mShop/PurchaseStatus;
    invoke-virtual {v13, v1}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->setPurchaseStatus(Lcom/amazon/rio/j2me/client/services/mShop/PurchaseStatus;)V

    .line 54
    .end local v1    # "data":Lcom/amazon/rio/j2me/client/services/mShop/PurchaseStatus;
    :cond_3
    invoke-virtual/range {p1 .. p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v12

    .line 55
    if-nez v12, :cond_4

    .line 57
    new-instance v14, Lcom/amazon/rio/j2me/client/codec/AddressDefaultDecoder;

    invoke-direct {v14}, Lcom/amazon/rio/j2me/client/codec/AddressDefaultDecoder;-><init>()V

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v14, v0, v15}, Lcom/amazon/rio/j2me/client/codec/AddressDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/Address;

    move-result-object v1

    .line 58
    .local v1, "data":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    invoke-virtual {v13, v1}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->setBillingAddress(Lcom/amazon/rio/j2me/client/services/mShop/Address;)V

    .line 61
    .end local v1    # "data":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    :cond_4
    invoke-virtual/range {p1 .. p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v12

    .line 62
    if-nez v12, :cond_5

    .line 64
    new-instance v14, Lcom/amazon/rio/j2me/client/codec/AddressDefaultDecoder;

    invoke-direct {v14}, Lcom/amazon/rio/j2me/client/codec/AddressDefaultDecoder;-><init>()V

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v14, v0, v15}, Lcom/amazon/rio/j2me/client/codec/AddressDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/Address;

    move-result-object v1

    .line 65
    .restart local v1    # "data":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    invoke-virtual {v13, v1}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->setShippingAddress(Lcom/amazon/rio/j2me/client/services/mShop/Address;)V

    .line 68
    .end local v1    # "data":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    :cond_5
    invoke-virtual/range {p1 .. p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v12

    .line 69
    if-nez v12, :cond_6

    .line 71
    new-instance v14, Lcom/amazon/rio/j2me/client/codec/OrderDefaultDecoder;

    invoke-direct {v14}, Lcom/amazon/rio/j2me/client/codec/OrderDefaultDecoder;-><init>()V

    invoke-static {v14}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v14

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-interface {v14, v0, v15}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/List;

    .line 72
    .local v6, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Order;>;"
    invoke-virtual {v13, v6}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->setOrder(Ljava/util/List;)V

    .line 75
    .end local v6    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Order;>;"
    :cond_6
    invoke-virtual/range {p1 .. p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v12

    .line 76
    if-nez v12, :cond_7

    .line 78
    new-instance v14, Lcom/amazon/rio/j2me/client/codec/OrderSummaryDefaultDecoder;

    invoke-direct {v14}, Lcom/amazon/rio/j2me/client/codec/OrderSummaryDefaultDecoder;-><init>()V

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v14, v0, v15}, Lcom/amazon/rio/j2me/client/codec/OrderSummaryDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/OrderSummary;

    move-result-object v1

    .line 79
    .local v1, "data":Lcom/amazon/rio/j2me/client/services/mShop/OrderSummary;
    invoke-virtual {v13, v1}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->setOrderSummary(Lcom/amazon/rio/j2me/client/services/mShop/OrderSummary;)V

    .line 82
    .end local v1    # "data":Lcom/amazon/rio/j2me/client/services/mShop/OrderSummary;
    :cond_7
    invoke-virtual/range {p1 .. p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v12

    .line 83
    if-nez v12, :cond_8

    .line 85
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v14

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-interface {v14, v0, v15}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 86
    .local v1, "data":Ljava/lang/String;
    invoke-virtual {v13, v1}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->setAcknowledgement(Ljava/lang/String;)V

    .line 89
    .end local v1    # "data":Ljava/lang/String;
    :cond_8
    invoke-virtual/range {p1 .. p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v12

    .line 90
    if-nez v12, :cond_9

    .line 92
    new-instance v14, Lcom/amazon/rio/j2me/client/codec/PaymentPlanDefaultDecoder;

    invoke-direct {v14}, Lcom/amazon/rio/j2me/client/codec/PaymentPlanDefaultDecoder;-><init>()V

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v14, v0, v15}, Lcom/amazon/rio/j2me/client/codec/PaymentPlanDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/PaymentPlan;

    move-result-object v1

    .line 93
    .local v1, "data":Lcom/amazon/rio/j2me/client/services/mShop/PaymentPlan;
    invoke-virtual {v13, v1}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->setPaymentPlan(Lcom/amazon/rio/j2me/client/services/mShop/PaymentPlan;)V

    .line 96
    .end local v1    # "data":Lcom/amazon/rio/j2me/client/services/mShop/PaymentPlan;
    :cond_9
    invoke-virtual/range {p1 .. p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v12

    .line 97
    if-nez v12, :cond_a

    .line 99
    new-instance v14, Lcom/amazon/rio/j2me/client/codec/GiftOptionSummaryDefaultDecoder;

    invoke-direct {v14}, Lcom/amazon/rio/j2me/client/codec/GiftOptionSummaryDefaultDecoder;-><init>()V

    invoke-static {v14}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v14

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-interface {v14, v0, v15}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    .line 100
    .local v4, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/GiftOptionSummary;>;"
    invoke-virtual {v13, v4}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->setGiftOptionSummary(Ljava/util/List;)V

    .line 103
    .end local v4    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/GiftOptionSummary;>;"
    :cond_a
    invoke-virtual/range {p1 .. p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v12

    .line 104
    if-nez v12, :cond_b

    .line 106
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v14

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-interface {v14, v0, v15}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 107
    .local v1, "data":Ljava/lang/String;
    invoke-virtual {v13, v1}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->setBuyNowSessionId(Ljava/lang/String;)V

    .line 110
    .end local v1    # "data":Ljava/lang/String;
    :cond_b
    invoke-virtual/range {p1 .. p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v12

    .line 111
    if-nez v12, :cond_c

    .line 113
    new-instance v14, Lcom/amazon/rio/j2me/client/codec/InvoiceCategoryDefaultDecoder;

    invoke-direct {v14}, Lcom/amazon/rio/j2me/client/codec/InvoiceCategoryDefaultDecoder;-><init>()V

    invoke-static {v14}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v14

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-interface {v14, v0, v15}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    .line 114
    .local v5, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/InvoiceCategory;>;"
    invoke-virtual {v13, v5}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->setInvoiceCategories(Ljava/util/List;)V

    .line 117
    .end local v5    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/InvoiceCategory;>;"
    :cond_c
    invoke-virtual/range {p1 .. p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v12

    .line 118
    if-nez v12, :cond_d

    .line 120
    new-instance v14, Lcom/amazon/rio/j2me/client/codec/CreditCardTypeDefaultDecoder;

    invoke-direct {v14}, Lcom/amazon/rio/j2me/client/codec/CreditCardTypeDefaultDecoder;-><init>()V

    invoke-static {v14}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v14

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-interface {v14, v0, v15}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    .line 121
    .local v3, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CreditCardType;>;"
    invoke-virtual {v13, v3}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->setCreditCardType(Ljava/util/List;)V

    .line 124
    .end local v3    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CreditCardType;>;"
    :cond_d
    invoke-virtual/range {p1 .. p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v12

    .line 125
    if-nez v12, :cond_e

    .line 127
    new-instance v14, Lcom/amazon/rio/j2me/client/codec/PaymentTypeDefaultDecoder;

    invoke-direct {v14}, Lcom/amazon/rio/j2me/client/codec/PaymentTypeDefaultDecoder;-><init>()V

    invoke-static {v14}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v14

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-interface {v14, v0, v15}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/List;

    .line 128
    .local v9, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PaymentType;>;"
    invoke-virtual {v13, v9}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->setPaymentType(Ljava/util/List;)V

    .line 131
    .end local v9    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PaymentType;>;"
    :cond_e
    invoke-virtual/range {p1 .. p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v12

    .line 132
    if-nez v12, :cond_f

    .line 134
    new-instance v14, Lcom/amazon/rio/j2me/client/codec/PaymentMethodDefaultDecoder;

    invoke-direct {v14}, Lcom/amazon/rio/j2me/client/codec/PaymentMethodDefaultDecoder;-><init>()V

    invoke-static {v14}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v14

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-interface {v14, v0, v15}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/List;

    .line 135
    .local v7, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;>;"
    invoke-virtual {v13, v7}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->setPaymentMethod(Ljava/util/List;)V

    .line 138
    .end local v7    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;>;"
    :cond_f
    invoke-virtual/range {p1 .. p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v12

    .line 139
    if-nez v12, :cond_10

    .line 141
    new-instance v14, Lcom/amazon/rio/j2me/client/codec/PaymentMethodInfoDefaultDecoder;

    invoke-direct {v14}, Lcom/amazon/rio/j2me/client/codec/PaymentMethodInfoDefaultDecoder;-><init>()V

    invoke-static {v14}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v14

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-interface {v14, v0, v15}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    .line 142
    .local v8, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethodInfo;>;"
    invoke-virtual {v13, v8}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->setPaymentMethodInfo(Ljava/util/List;)V

    .line 145
    .end local v8    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethodInfo;>;"
    :cond_10
    invoke-virtual/range {p1 .. p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v12

    .line 146
    if-nez v12, :cond_11

    .line 148
    new-instance v14, Lcom/amazon/rio/j2me/client/codec/AddressDefaultDecoder;

    invoke-direct {v14}, Lcom/amazon/rio/j2me/client/codec/AddressDefaultDecoder;-><init>()V

    invoke-static {v14}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v14

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-interface {v14, v0, v15}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    .line 149
    .local v2, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Address;>;"
    invoke-virtual {v13, v2}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->setAddress(Ljava/util/List;)V

    .line 152
    .end local v2    # "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Address;>;"
    :cond_11
    invoke-virtual/range {p1 .. p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v12

    .line 153
    if-nez v12, :cond_12

    .line 155
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v14

    invoke-static {v14}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v14

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-interface {v14, v0, v15}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/util/List;

    .line 156
    .restart local v11    # "data":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {v13, v11}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->setConfirmedOrderId(Ljava/util/List;)V

    .line 159
    .end local v11    # "data":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_12
    invoke-virtual/range {p1 .. p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v12

    .line 160
    if-nez v12, :cond_13

    .line 162
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v14

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-interface {v14, v0, v15}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 163
    .restart local v1    # "data":Ljava/lang/String;
    invoke-virtual {v13, v1}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->setRecipientName(Ljava/lang/String;)V

    .line 166
    .end local v1    # "data":Ljava/lang/String;
    :cond_13
    invoke-virtual/range {p1 .. p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v12

    .line 167
    if-nez v12, :cond_14

    .line 169
    const-wide/32 v14, -0x80000000

    const-wide/32 v16, 0x7fffffff

    invoke-static/range {v14 .. v17}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v14

    const/4 v15, 0x0

    move-object/from16 v0, p1

    invoke-interface {v14, v0, v15}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    .line 170
    .local v1, "data":Ljava/lang/Integer;
    invoke-virtual {v13, v1}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->setMsToCheckout(Ljava/lang/Integer;)V

    .line 172
    .end local v1    # "data":Ljava/lang/Integer;
    :cond_14
    return-object v13
.end method

.method public bridge synthetic decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/io/DataInputStream;
    .param p2, "x1"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 17
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/PurchaseOrderResponseDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;

    move-result-object v0

    return-object v0
.end method
