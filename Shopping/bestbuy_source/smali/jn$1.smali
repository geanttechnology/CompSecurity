.class Ljn$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljn;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljn;


# direct methods
.method constructor <init>(Ljn;)V
    .locals 0

    .prologue
    .line 112
    iput-object p1, p0, Ljn$1;->a:Ljn;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Ljn$1;->a:Ljn;

    invoke-virtual {v0}, Ljn;->d()V

    .line 116
    return-void
.end method
