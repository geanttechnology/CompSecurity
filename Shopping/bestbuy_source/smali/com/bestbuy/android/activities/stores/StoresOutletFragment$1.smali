.class Lcom/bestbuy/android/activities/stores/StoresOutletFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->a(Lmy;)V
.end annotation


# instance fields
.field final synthetic a:Lmw;

.field final synthetic b:Lcom/bestbuy/android/activities/stores/StoresOutletFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/stores/StoresOutletFragment;Lmw;)V
    .locals 0

    .prologue
    .line 160
    iput-object p1, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment$1;->b:Lcom/bestbuy/android/activities/stores/StoresOutletFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment$1;->a:Lmw;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 164
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment$1;->a:Lmw;

    invoke-virtual {v0}, Lmw;->e()Ljava/lang/String;

    move-result-object v0

    .line 165
    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment$1;->b:Lcom/bestbuy/android/activities/stores/StoresOutletFragment;

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment$1;->a:Lmw;

    invoke-virtual {v2}, Lmw;->i()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/stores/StoresOutletFragment$1;->a:Lmw;

    invoke-virtual {v3}, Lmw;->f()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v0, v2, v3}, Lcom/bestbuy/android/activities/stores/StoresOutletFragment;->a(Lcom/bestbuy/android/activities/stores/StoresOutletFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 166
    return-void
.end method
