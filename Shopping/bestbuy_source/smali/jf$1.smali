.class Ljf$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljf;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljf;


# direct methods
.method constructor <init>(Ljf;)V
    .locals 0

    .prologue
    .line 67
    iput-object p1, p0, Ljf$1;->a:Ljf;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Ljf$1;->a:Ljf;

    invoke-virtual {v0}, Ljf;->d()V

    .line 71
    return-void
.end method
