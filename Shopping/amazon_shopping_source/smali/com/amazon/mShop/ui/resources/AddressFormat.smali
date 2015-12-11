.class public Lcom/amazon/mShop/ui/resources/AddressFormat;
.super Ljava/lang/Object;
.source "AddressFormat.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static appendAddress(Lcom/amazon/rio/j2me/client/services/mShop/Address;Ljava/lang/StringBuffer;I)V
    .locals 8
    .param p0, "address"    # Lcom/amazon/rio/j2me/client/services/mShop/Address;
    .param p1, "out"    # Ljava/lang/StringBuffer;
    .param p2, "format"    # I

    .prologue
    .line 56
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v6

    invoke-interface {v6}, Lcom/amazon/mShop/platform/Platform;->getResources()Lcom/amazon/mShop/platform/Resources;

    move-result-object v6

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getCountryCode()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7}, Lcom/amazon/mShop/platform/Resources;->getAddressFormat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 59
    .local v5, "localeFormat":Ljava/lang/String;
    const/4 v2, 0x1

    .line 60
    .local v2, "hasName":Z
    const/4 v3, 0x1

    .line 61
    .local v3, "hasPhone":Z
    const/4 v1, 0x1

    .line 63
    .local v1, "hasCountry":Z
    packed-switch p2, :pswitch_data_0

    .line 79
    :goto_0
    :pswitch_0
    new-instance v0, Ljava/util/Hashtable;

    const/16 v6, 0xa

    invoke-direct {v0, v6}, Ljava/util/Hashtable;-><init>(I)V

    .line 81
    .local v0, "addressMacros":Ljava/util/Hashtable;, "Ljava/util/Hashtable<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v2, :cond_0

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getName()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_0

    .line 82
    const-string/jumbo v6, "name"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v6, v7}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 84
    :cond_0
    if-eqz v3, :cond_1

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getPhone()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_1

    .line 85
    const-string/jumbo v6, "phone"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getPhone()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v6, v7}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 87
    :cond_1
    if-eqz v1, :cond_2

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getCountry()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_2

    .line 88
    const-string/jumbo v6, "country"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getCountry()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v6, v7}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 90
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getAddress1()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_3

    .line 91
    const-string/jumbo v6, "address1"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getAddress1()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v6, v7}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 93
    :cond_3
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getAddress2()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_4

    .line 94
    const-string/jumbo v6, "address2"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getAddress2()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v6, v7}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 96
    :cond_4
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getAddress3()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_5

    .line 97
    const-string/jumbo v6, "address3"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getAddress3()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v6, v7}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 99
    :cond_5
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getCity()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_6

    .line 100
    const-string/jumbo v6, "city"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getCity()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v6, v7}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 102
    :cond_6
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getState()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_7

    .line 103
    const-string/jumbo v6, "state"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getState()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v6, v7}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 105
    :cond_7
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getZip()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_8

    .line 106
    const-string/jumbo v6, "zip"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getZip()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v6, v7}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 108
    :cond_8
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getCounty()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_9

    .line 109
    const-string/jumbo v6, "county"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getCounty()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v6, v7}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 112
    :cond_9
    invoke-static {v5, v0, p1}, Lcom/amazon/mShop/ui/resources/AddressFormat;->formatCollapseSeparators(Ljava/lang/String;Ljava/util/Hashtable;Ljava/lang/StringBuffer;)V

    .line 115
    if-eqz p2, :cond_a

    const/4 v6, 0x3

    if-ne p2, v6, :cond_b

    .line 116
    :cond_a
    const/4 v4, -0x1

    .line 117
    .local v4, "index":I
    :goto_1
    const-string/jumbo v6, "\n"

    invoke-virtual {p1, v6}, Ljava/lang/StringBuffer;->indexOf(Ljava/lang/String;)I

    move-result v4

    const/4 v6, -0x1

    if-eq v4, v6, :cond_b

    .line 118
    add-int/lit8 v6, v4, 0x1

    const-string/jumbo v7, " "

    invoke-virtual {p1, v4, v6, v7}, Ljava/lang/StringBuffer;->replace(IILjava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_1

    .line 65
    .end local v0    # "addressMacros":Ljava/util/Hashtable;, "Ljava/util/Hashtable<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v4    # "index":I
    :pswitch_1
    const/4 v2, 0x0

    .line 66
    const/4 v3, 0x0

    .line 67
    const/4 v1, 0x0

    .line 68
    goto/16 :goto_0

    .line 70
    :pswitch_2
    const/4 v3, 0x0

    .line 71
    goto/16 :goto_0

    .line 73
    :pswitch_3
    const/4 v3, 0x0

    .line 74
    const/4 v1, 0x0

    goto/16 :goto_0

    .line 122
    .restart local v0    # "addressMacros":Ljava/util/Hashtable;, "Ljava/util/Hashtable<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_b
    return-void

    .line 63
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method public static formatAddress(Lcom/amazon/rio/j2me/client/services/mShop/Address;I)Ljava/lang/String;
    .locals 3
    .param p0, "address"    # Lcom/amazon/rio/j2me/client/services/mShop/Address;
    .param p1, "format"    # I

    .prologue
    const/4 v1, 0x0

    .line 28
    if-nez p0, :cond_1

    .line 38
    :cond_0
    :goto_0
    return-object v1

    .line 32
    :cond_1
    new-instance v0, Ljava/lang/StringBuffer;

    const/16 v2, 0x80

    invoke-direct {v0, v2}, Ljava/lang/StringBuffer;-><init>(I)V

    .line 33
    .local v0, "out":Ljava/lang/StringBuffer;
    invoke-static {p0, v0, p1}, Lcom/amazon/mShop/ui/resources/AddressFormat;->appendAddress(Lcom/amazon/rio/j2me/client/services/mShop/Address;Ljava/lang/StringBuffer;I)V

    .line 34
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->length()I

    move-result v2

    if-eqz v2, :cond_0

    .line 38
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method private static formatCollapseSeparators(Ljava/lang/String;Ljava/util/Hashtable;Ljava/lang/StringBuffer;)V
    .locals 12
    .param p0, "localeFormat"    # Ljava/lang/String;
    .param p2, "formattedValue"    # Ljava/lang/StringBuffer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Hashtable",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/StringBuffer;",
            ")V"
        }
    .end annotation

    .prologue
    .local p1, "macros":Ljava/util/Hashtable;, "Ljava/util/Hashtable<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v11, -0x1

    .line 179
    const/4 v7, 0x0

    .line 180
    .local v7, "separator":Ljava/lang/String;
    const/4 v8, 0x0

    .line 183
    .local v8, "separatorWeight":I
    const/4 v0, 0x0

    .local v0, "index":I
    :goto_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v9

    if-ge v0, v9, :cond_0

    .line 185
    const-string/jumbo v9, "{"

    invoke-virtual {p0, v9, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v5

    .line 186
    .local v5, "macroStartIndex":I
    if-ne v5, v11, :cond_1

    .line 224
    .end local v5    # "macroStartIndex":I
    :cond_0
    return-void

    .line 189
    .restart local v5    # "macroStartIndex":I
    :cond_1
    const-string/jumbo v9, "}"

    add-int/lit8 v10, v5, 0x1

    invoke-virtual {p0, v9, v10}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v3

    .line 190
    .local v3, "macroEndIndex":I
    if-eq v3, v11, :cond_0

    .line 195
    invoke-virtual {p0, v0, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 196
    .local v1, "latestSeparator":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/ui/resources/AddressFormat;->getSeparatorWeight(Ljava/lang/String;)I

    move-result v2

    .line 199
    .local v2, "latestSeparatorWeight":I
    if-eqz v7, :cond_2

    if-lt v2, v8, :cond_3

    .line 201
    :cond_2
    move-object v7, v1

    .line 202
    move v8, v2

    .line 205
    :cond_3
    const-string/jumbo v9, "{"

    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v9

    add-int/2addr v9, v5

    invoke-virtual {p0, v9, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    .line 206
    .local v4, "macroName":Ljava/lang/String;
    invoke-virtual {p1, v4}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 209
    .local v6, "macroValue":Ljava/lang/String;
    if-eqz v6, :cond_5

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v9

    if-lez v9, :cond_5

    .line 211
    invoke-virtual {p2}, Ljava/lang/StringBuffer;->length()I

    move-result v9

    if-lez v9, :cond_4

    .line 212
    invoke-virtual {p2, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 214
    const/4 v7, 0x0

    .line 217
    :cond_4
    invoke-virtual {p2, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 221
    :cond_5
    const-string/jumbo v9, "}"

    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v9

    add-int v0, v3, v9

    .line 222
    goto :goto_0
.end method

.method public static formatOneClickAddress(Lcom/amazon/rio/j2me/client/services/mShop/Address;Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;)Ljava/lang/String;
    .locals 2
    .param p0, "address"    # Lcom/amazon/rio/j2me/client/services/mShop/Address;
    .param p1, "paymentMethod"    # Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    .prologue
    .line 42
    new-instance v0, Ljava/lang/StringBuffer;

    const/16 v1, 0x80

    invoke-direct {v0, v1}, Ljava/lang/StringBuffer;-><init>(I)V

    .line 43
    .local v0, "out":Ljava/lang/StringBuffer;
    const/4 v1, 0x1

    invoke-static {p0, v0, v1}, Lcom/amazon/mShop/ui/resources/AddressFormat;->appendAddress(Lcom/amazon/rio/j2me/client/services/mShop/Address;Ljava/lang/StringBuffer;I)V

    .line 44
    if-eqz p1, :cond_0

    .line 45
    const-string/jumbo v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 46
    invoke-static {p1, v0}, Lcom/amazon/mShop/ui/resources/PaymentFormat;->appendPaymentMethod(Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;Ljava/lang/StringBuffer;)V

    .line 48
    :cond_0
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private static getSeparatorWeight(Ljava/lang/String;)I
    .locals 4
    .param p0, "separator"    # Ljava/lang/String;

    .prologue
    .line 134
    const/4 v2, 0x0

    .line 136
    .local v2, "weight":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    if-ge v1, v3, :cond_2

    .line 137
    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 139
    .local v0, "c":C
    const/16 v3, 0xa

    if-ne v0, v3, :cond_0

    .line 141
    const/high16 v3, 0x100000

    add-int/2addr v2, v3

    .line 136
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 142
    :cond_0
    invoke-static {v0}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 144
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 147
    :cond_1
    add-int/lit16 v2, v2, 0x400

    goto :goto_1

    .line 151
    .end local v0    # "c":C
    :cond_2
    return v2
.end method
