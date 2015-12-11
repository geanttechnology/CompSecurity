.class public Lcom/amazon/mShop/ui/resources/PaymentFormat;
.super Ljava/lang/Object;
.source "PaymentFormat.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static appendPaymentMethod(Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;Ljava/lang/StringBuffer;)V
    .locals 3
    .param p0, "paymentMethod"    # Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;
    .param p1, "out"    # Ljava/lang/StringBuffer;

    .prologue
    .line 32
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getResources()Lcom/amazon/mShop/platform/Resources;

    move-result-object v0

    .line 34
    .local v0, "res":Lcom/amazon/mShop/platform/Resources;
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->getIssuer()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 35
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->getIssuer()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 38
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->getNumber()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 39
    const-string/jumbo v1, " ***"

    invoke-virtual {p1, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 40
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->getNumber()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 44
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->getMethod()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_3

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->getMethod()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "creditCard"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->getMonth()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_3

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->getYear()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 48
    invoke-virtual {p1}, Ljava/lang/StringBuffer;->length()I

    move-result v1

    if-lez v1, :cond_2

    .line 49
    const-string/jumbo v1, "\n"

    invoke-virtual {p1, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 51
    :cond_2
    const/4 v1, 0x1

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 52
    const-string/jumbo v1, "\u00a0"

    invoke-virtual {p1, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 53
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->getMonth()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 54
    const/16 v1, 0x2f

    invoke-virtual {p1, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 55
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->getYear()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 58
    :cond_3
    return-void
.end method

.method public static formatPaymentMethod(Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;)Ljava/lang/String;
    .locals 2
    .param p0, "paymentMethod"    # Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    .prologue
    .line 62
    new-instance v0, Ljava/lang/StringBuffer;

    const/16 v1, 0x40

    invoke-direct {v0, v1}, Ljava/lang/StringBuffer;-><init>(I)V

    .line 63
    .local v0, "out":Ljava/lang/StringBuffer;
    invoke-static {p0, v0}, Lcom/amazon/mShop/ui/resources/PaymentFormat;->appendPaymentMethod(Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;Ljava/lang/StringBuffer;)V

    .line 64
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
