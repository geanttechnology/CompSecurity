.class Lhx$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lhx;->c()V
.end annotation


# instance fields
.field final synthetic a:Lhx;


# direct methods
.method constructor <init>(Lhx;)V
    .locals 0

    .prologue
    .line 73
    iput-object p1, p0, Lhx$2;->a:Lhx;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 75
    iget-object v0, p0, Lhx$2;->a:Lhx;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lhx;->a(Lhx;I)I

    .line 76
    iget-object v0, p0, Lhx$2;->a:Lhx;

    invoke-static {v0}, Lhx;->h(Lhx;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 77
    return-void
.end method
