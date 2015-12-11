.class public Lcom/xfinity/playerlib/authorization/VideoContinue;
.super Ljava/lang/Object;
.source "VideoContinue.java"

# interfaces
.implements Lcom/xfinity/playerlib/authorization/VideoSession;


# instance fields
.field private final errorMessage:Ljava/lang/String;

.field private final statusCode:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "errorMessage"    # Ljava/lang/String;
    .param p2, "statusCode"    # Ljava/lang/String;

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/VideoContinue;->errorMessage:Ljava/lang/String;

    .line 10
    iput-object p2, p0, Lcom/xfinity/playerlib/authorization/VideoContinue;->statusCode:Ljava/lang/String;

    .line 11
    return-void
.end method


# virtual methods
.method public getErrorMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 14
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoContinue;->errorMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getStatusCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoContinue;->statusCode:Ljava/lang/String;

    return-object v0
.end method
