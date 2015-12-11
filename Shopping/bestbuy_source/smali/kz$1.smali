.class Lkz$1;
.super Landroid/content/BroadcastReceiver;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lkz;
.end annotation


# instance fields
.field final synthetic a:Lkz;


# direct methods
.method constructor <init>(Lkz;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lkz$1;->a:Lkz;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lkz$1;->a:Lkz;

    invoke-static {v0}, Lkz;->a(Lkz;)V

    .line 54
    return-void
.end method
