.class Lcom/exacttarget/etpushsdk/adapter/a;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;


# direct methods
.method constructor <init>(Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;)V
    .locals 0

    .prologue
    .line 70
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/adapter/a;->a:Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/adapter/a;->a:Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->notifyDataSetChanged()V

    .line 73
    return-void
.end method
