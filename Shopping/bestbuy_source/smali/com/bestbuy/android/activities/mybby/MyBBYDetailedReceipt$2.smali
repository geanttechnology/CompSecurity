.class Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->a(Lcom/bestbuy/android/api/lib/models/remix/Store;)V
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 181
    iput-object p1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$2;->b:Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;

    iput-object p2, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$2;->a:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$2;->b:Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$2;->a:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->a(Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;Landroid/content/Context;Ljava/lang/String;)V

    .line 184
    return-void
.end method
