.class Lcom/amazon/avod/sdk/internal/BindingConnection$HandleResponseTask;
.super Ljava/lang/Object;
.source "BindingConnection.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/avod/sdk/internal/BindingConnection;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "HandleResponseTask"
.end annotation


# instance fields
.field private final mHandler:Lcom/amazon/avod/sdk/ResponseHandler;

.field private final mResponse:Lcom/amazon/avod/sdk/CallResponse;


# direct methods
.method private constructor <init>(Lcom/amazon/avod/sdk/ResponseHandler;Lcom/amazon/avod/sdk/CallResponse;)V
    .locals 0
    .param p1, "handler"    # Lcom/amazon/avod/sdk/ResponseHandler;
    .param p2, "response"    # Lcom/amazon/avod/sdk/CallResponse;

    .prologue
    .line 308
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 309
    iput-object p1, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$HandleResponseTask;->mHandler:Lcom/amazon/avod/sdk/ResponseHandler;

    .line 310
    iput-object p2, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$HandleResponseTask;->mResponse:Lcom/amazon/avod/sdk/CallResponse;

    .line 311
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/avod/sdk/ResponseHandler;Lcom/amazon/avod/sdk/CallResponse;Lcom/amazon/avod/sdk/internal/BindingConnection$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/avod/sdk/ResponseHandler;
    .param p2, "x1"    # Lcom/amazon/avod/sdk/CallResponse;
    .param p3, "x2"    # Lcom/amazon/avod/sdk/internal/BindingConnection$1;

    .prologue
    .line 304
    invoke-direct {p0, p1, p2}, Lcom/amazon/avod/sdk/internal/BindingConnection$HandleResponseTask;-><init>(Lcom/amazon/avod/sdk/ResponseHandler;Lcom/amazon/avod/sdk/CallResponse;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 315
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$HandleResponseTask;->mHandler:Lcom/amazon/avod/sdk/ResponseHandler;

    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$HandleResponseTask;->mResponse:Lcom/amazon/avod/sdk/CallResponse;

    invoke-interface {v0, v1}, Lcom/amazon/avod/sdk/ResponseHandler;->handleResponse(Lcom/amazon/avod/sdk/CallResponse;)V

    .line 316
    return-void
.end method
