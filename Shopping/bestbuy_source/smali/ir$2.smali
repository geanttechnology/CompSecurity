.class Lir$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lir;->c()V
.end annotation


# instance fields
.field final synthetic a:Lir;


# direct methods
.method constructor <init>(Lir;)V
    .locals 0

    .prologue
    .line 89
    iput-object p1, p0, Lir$2;->a:Lir;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 91
    const/4 v0, 0x0

    invoke-static {v0}, Lir;->a(I)I

    .line 92
    iget-object v0, p0, Lir$2;->a:Lir;

    invoke-static {v0}, Lir;->o(Lir;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 93
    return-void
.end method
