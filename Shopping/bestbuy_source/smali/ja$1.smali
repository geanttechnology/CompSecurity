.class Lja$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lja;->c()V
.end annotation


# instance fields
.field final synthetic a:Lja;


# direct methods
.method constructor <init>(Lja;)V
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lja$1;->a:Lja;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lja$1;->a:Lja;

    invoke-virtual {v0}, Lja;->d()V

    .line 75
    return-void
.end method
