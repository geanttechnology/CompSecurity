.class Lcom/amazon/mShop/cvsd/CVSDMapActivity$1;
.super Ljava/lang/Object;
.source "CVSDMapActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/cvsd/CVSDMapActivity;->onCreate(Landroid/os/Bundle;)V
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
    .line 139
    iput-object p1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$1;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 143
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$1;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # invokes: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->createSearchOptionDialog()V
    invoke-static {v0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$000(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V

    .line 144
    return-void
.end method
