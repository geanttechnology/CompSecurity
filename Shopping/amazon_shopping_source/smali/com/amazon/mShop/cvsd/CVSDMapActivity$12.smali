.class Lcom/amazon/mShop/cvsd/CVSDMapActivity$12;
.super Ljava/lang/Object;
.source "CVSDMapActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchByZipCode()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V
    .locals 0

    .prologue
    .line 712
    iput-object p1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$12;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 716
    const/4 v0, -0x2

    if-ne p2, v0, :cond_0

    .line 717
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$12;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->finish()V

    .line 720
    :cond_0
    return-void
.end method
