.class Ljm$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljm;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljm;


# direct methods
.method constructor <init>(Ljm;)V
    .locals 0

    .prologue
    .line 70
    iput-object p1, p0, Ljm$1;->a:Ljm;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 73
    invoke-static {}, Ljm;->f()I

    .line 74
    iget-object v0, p0, Ljm$1;->a:Ljm;

    invoke-virtual {v0}, Ljm;->d()V

    .line 75
    return-void
.end method
