.class Ljw$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljw;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljw;


# direct methods
.method constructor <init>(Ljw;)V
    .locals 0

    .prologue
    .line 75
    iput-object p1, p0, Ljw$1;->a:Ljw;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Ljw$1;->a:Ljw;

    invoke-virtual {v0}, Ljw;->d()V

    .line 79
    return-void
.end method
