.class Ljp$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljp;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljp;


# direct methods
.method constructor <init>(Ljp;)V
    .locals 0

    .prologue
    .line 68
    iput-object p1, p0, Ljp$1;->a:Ljp;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Ljp$1;->a:Ljp;

    invoke-virtual {v0}, Ljp;->d()V

    .line 72
    return-void
.end method
