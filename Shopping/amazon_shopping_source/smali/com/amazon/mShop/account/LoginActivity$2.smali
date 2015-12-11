.class Lcom/amazon/mShop/account/LoginActivity$2;
.super Ljava/lang/Object;
.source "LoginActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/account/LoginActivity;->postLogin(ZLcom/amazon/rio/j2me/client/services/mShop/Notification;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/account/LoginActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/account/LoginActivity;)V
    .locals 0

    .prologue
    .line 605
    iput-object p1, p0, Lcom/amazon/mShop/account/LoginActivity$2;->this$0:Lcom/amazon/mShop/account/LoginActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 608
    iget-object v0, p0, Lcom/amazon/mShop/account/LoginActivity$2;->this$0:Lcom/amazon/mShop/account/LoginActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/account/LoginActivity;->finish()V

    .line 609
    return-void
.end method
