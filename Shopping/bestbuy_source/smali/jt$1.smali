.class Ljt$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljt;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljt;


# direct methods
.method constructor <init>(Ljt;)V
    .locals 0

    .prologue
    .line 66
    iput-object p1, p0, Ljt$1;->a:Ljt;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 69
    invoke-static {}, Ljt;->f()I

    .line 70
    iget-object v0, p0, Ljt$1;->a:Ljt;

    invoke-virtual {v0}, Ljt;->d()V

    .line 71
    return-void
.end method
