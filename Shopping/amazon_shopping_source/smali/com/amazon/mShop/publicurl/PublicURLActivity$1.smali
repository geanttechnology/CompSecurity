.class Lcom/amazon/mShop/publicurl/PublicURLActivity$1;
.super Ljava/lang/Object;
.source "PublicURLActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/publicurl/PublicURLActivity;->processURL()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/publicurl/PublicURLActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/publicurl/PublicURLActivity;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lcom/amazon/mShop/publicurl/PublicURLActivity$1;->this$0:Lcom/amazon/mShop/publicurl/PublicURLActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 61
    iget-object v0, p0, Lcom/amazon/mShop/publicurl/PublicURLActivity$1;->this$0:Lcom/amazon/mShop/publicurl/PublicURLActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/publicurl/PublicURLActivity;->finish()V

    .line 62
    return-void
.end method
