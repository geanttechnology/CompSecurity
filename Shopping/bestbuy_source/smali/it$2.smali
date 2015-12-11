.class Lit$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lit;->c()V
.end annotation


# instance fields
.field final synthetic a:Lit;


# direct methods
.method constructor <init>(Lit;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lit$2;->a:Lit;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 57
    const/4 v0, 0x0

    invoke-static {v0}, Lit;->a(I)I

    .line 58
    iget-object v0, p0, Lit$2;->a:Lit;

    invoke-static {v0}, Lit;->c(Lit;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 59
    return-void
.end method
