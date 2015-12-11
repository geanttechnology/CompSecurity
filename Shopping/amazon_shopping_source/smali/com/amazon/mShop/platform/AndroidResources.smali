.class public Lcom/amazon/mShop/platform/AndroidResources;
.super Ljava/lang/Object;
.source "AndroidResources.java"

# interfaces
.implements Lcom/amazon/mShop/platform/Resources;


# instance fields
.field private final res:Landroid/content/res/Resources;


# direct methods
.method public constructor <init>(Landroid/content/res/Resources;)V
    .locals 0
    .param p1, "resources"    # Landroid/content/res/Resources;

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/amazon/mShop/platform/AndroidResources;->res:Landroid/content/res/Resources;

    .line 19
    return-void
.end method


# virtual methods
.method public getAddressFormat(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "countryCode"    # Ljava/lang/String;

    .prologue
    .line 68
    const-string/jumbo v0, "CN"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 69
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidResources;->res:Landroid/content/res/Resources;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->address_format_CN:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 75
    :goto_0
    return-object v0

    .line 70
    :cond_0
    const-string/jumbo v0, "FR"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 71
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidResources;->res:Landroid/content/res/Resources;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->address_format_FR:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 72
    :cond_1
    const-string/jumbo v0, "JP"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 73
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidResources;->res:Landroid/content/res/Resources;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->address_format_JP:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 75
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidResources;->res:Landroid/content/res/Resources;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->address_format_default:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getDimensionPixelSize(I)Ljava/lang/Integer;
    .locals 2
    .param p1, "resourceId"    # I

    .prologue
    .line 48
    packed-switch p1, :pswitch_data_0

    .line 52
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 50
    :pswitch_0
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidResources;->res:Landroid/content/res/Resources;

    sget v1, Lcom/amazon/mShop/android/lib/R$dimen;->product_images_height:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    goto :goto_0

    .line 48
    :pswitch_data_0
    .packed-switch 0xb
        :pswitch_0
    .end packed-switch
.end method

.method public getString(I)Ljava/lang/String;
    .locals 2
    .param p1, "resourceId"    # I

    .prologue
    .line 23
    packed-switch p1, :pswitch_data_0

    .line 43
    :pswitch_0
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 25
    :pswitch_1
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidResources;->res:Landroid/content/res/Resources;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->opl_gift_options_gift_wrap_no_gift_wrap:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 27
    :pswitch_2
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidResources;->res:Landroid/content/res/Resources;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->payment_format_credit_card_expiration_date_addreviated:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 29
    :pswitch_3
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidResources;->res:Landroid/content/res/Resources;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->opl_order_status_error_invalid_billing_address:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 31
    :pswitch_4
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidResources;->res:Landroid/content/res/Resources;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->opl_order_status_error_cannot_ship_to_address:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 33
    :pswitch_5
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidResources;->res:Landroid/content/res/Resources;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->opl_order_status_error_purchase_error:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 35
    :pswitch_6
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidResources;->res:Landroid/content/res/Resources;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->opl_order_status_error_quantity_unavailable:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 37
    :pswitch_7
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidResources;->res:Landroid/content/res/Resources;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->opl_order_status_error_address_needs_correcting:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 39
    :pswitch_8
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidResources;->res:Landroid/content/res/Resources;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->opl_order_status_error_invalid_payment_plan:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 41
    :pswitch_9
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidResources;->res:Landroid/content/res/Resources;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->opl_delivery_time_select_error:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 23
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
    .end packed-switch
.end method
