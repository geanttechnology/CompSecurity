.class Lid$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lid;->c()V
.end annotation


# instance fields
.field final synthetic a:Lid;


# direct methods
.method constructor <init>(Lid;)V
    .locals 0

    .prologue
    .line 91
    iput-object p1, p0, Lid$1;->a:Lid;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lid$1;->a:Lid;

    invoke-virtual {v0}, Lid;->d()V

    .line 95
    return-void
.end method
