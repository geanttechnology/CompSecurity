.class final Lcom/amazon/mShop/util/AppUtils$2;
.super Ljava/lang/Object;
.source "AppUtils.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/AppUtils;->showSwitchLocaleDialog(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$activity:Lcom/amazon/mShop/AmazonActivity;

.field final synthetic val$launchIntent:Landroid/content/Intent;

.field final synthetic val$loacleName:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Landroid/content/Intent;)V
    .locals 0

    .prologue
    .line 250
    iput-object p1, p0, Lcom/amazon/mShop/util/AppUtils$2;->val$activity:Lcom/amazon/mShop/AmazonActivity;

    iput-object p2, p0, Lcom/amazon/mShop/util/AppUtils$2;->val$loacleName:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/util/AppUtils$2;->val$launchIntent:Landroid/content/Intent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 253
    packed-switch p2, :pswitch_data_0

    .line 261
    :goto_0
    return-void

    .line 255
    :pswitch_0
    iget-object v0, p0, Lcom/amazon/mShop/util/AppUtils$2;->val$activity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->finish()V

    goto :goto_0

    .line 258
    :pswitch_1
    iget-object v0, p0, Lcom/amazon/mShop/util/AppUtils$2;->val$loacleName:Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/mShop/util/AppUtils$2;->val$activity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v2, p0, Lcom/amazon/mShop/util/AppUtils$2;->val$launchIntent:Landroid/content/Intent;

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/util/LocaleUtils;->changeLocale(Ljava/lang/String;Landroid/content/Context;Landroid/content/Intent;)V

    goto :goto_0

    .line 253
    :pswitch_data_0
    .packed-switch -0x2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
