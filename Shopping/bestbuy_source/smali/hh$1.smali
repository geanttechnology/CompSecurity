.class Lhh$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lhh;->c()V
.end annotation


# instance fields
.field final synthetic a:Lhh;


# direct methods
.method constructor <init>(Lhh;)V
    .locals 0

    .prologue
    .line 59
    iput-object p1, p0, Lhh$1;->a:Lhh;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lhh$1;->a:Lhh;

    invoke-virtual {v0}, Lhh;->d()V

    .line 63
    return-void
.end method
