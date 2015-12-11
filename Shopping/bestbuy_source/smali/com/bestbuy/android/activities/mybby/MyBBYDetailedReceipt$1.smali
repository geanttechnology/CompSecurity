.class Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->a(Lcom/bestbuy/android/api/lib/models/remix/Store;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;)V
    .locals 0

    .prologue
    .line 130
    iput-object p1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$1;->a:Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 133
    new-instance v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>()V

    .line 134
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 135
    const-string v2, "ProductObject"

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 136
    const-string v2, "SKU"

    iget-object v3, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$1;->a:Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;

    invoke-static {v3}, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->a(Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 137
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 138
    return-void
.end method
