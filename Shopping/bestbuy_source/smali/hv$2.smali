.class Lhv$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lhv;->c()V
.end annotation


# instance fields
.field final synthetic a:Lhv;


# direct methods
.method constructor <init>(Lhv;)V
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lhv$2;->a:Lhv;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 71
    iget-object v0, p0, Lhv$2;->a:Lhv;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lhv;->a(Lhv;I)I

    .line 72
    iget-object v0, p0, Lhv$2;->a:Lhv;

    invoke-static {v0}, Lhv;->b(Lhv;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 73
    return-void
.end method
