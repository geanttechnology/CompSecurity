.class Ljg$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljg;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljg;


# direct methods
.method constructor <init>(Ljg;)V
    .locals 0

    .prologue
    .line 70
    iput-object p1, p0, Ljg$1;->a:Ljg;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Ljg$1;->a:Ljg;

    invoke-virtual {v0}, Ljg;->d()V

    .line 74
    return-void
.end method
