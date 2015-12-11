.class Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;
.super Ljava/lang/Object;
.source "AmazonAlertDialog.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/AmazonAlertDialog$Builder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ButtonData"
.end annotation


# instance fields
.field public final listener:Landroid/content/DialogInterface$OnClickListener;

.field public final textResId:I

.field final synthetic this$0:Lcom/amazon/mShop/AmazonAlertDialog$Builder;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/AmazonAlertDialog$Builder;ILandroid/content/DialogInterface$OnClickListener;)V
    .locals 0
    .param p2, "_textResId"    # I
    .param p3, "_listener"    # Landroid/content/DialogInterface$OnClickListener;

    .prologue
    .line 273
    iput-object p1, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;->this$0:Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 274
    iput p2, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;->textResId:I

    .line 275
    iput-object p3, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;->listener:Landroid/content/DialogInterface$OnClickListener;

    .line 276
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/AmazonAlertDialog$Builder;ILandroid/content/DialogInterface$OnClickListener;Lcom/amazon/mShop/AmazonAlertDialog$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    .param p2, "x1"    # I
    .param p3, "x2"    # Landroid/content/DialogInterface$OnClickListener;
    .param p4, "x3"    # Lcom/amazon/mShop/AmazonAlertDialog$1;

    .prologue
    .line 268
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;-><init>(Lcom/amazon/mShop/AmazonAlertDialog$Builder;ILandroid/content/DialogInterface$OnClickListener;)V

    return-void
.end method
