.class public Lcom/amazon/android/webkit/AmazonConsoleMessage;
.super Ljava/lang/Object;
.source "AmazonConsoleMessage.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/android/webkit/AmazonConsoleMessage$MessageLevel;
    }
.end annotation


# instance fields
.field private final level:Lcom/amazon/android/webkit/AmazonConsoleMessage$MessageLevel;

.field private final lineNumber:I

.field private final message:Ljava/lang/String;

.field private final sourceId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ILcom/amazon/android/webkit/AmazonConsoleMessage$MessageLevel;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "sourceId"    # Ljava/lang/String;
    .param p3, "lineNumber"    # I
    .param p4, "level"    # Lcom/amazon/android/webkit/AmazonConsoleMessage$MessageLevel;

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput-object p1, p0, Lcom/amazon/android/webkit/AmazonConsoleMessage;->message:Ljava/lang/String;

    .line 40
    iput-object p2, p0, Lcom/amazon/android/webkit/AmazonConsoleMessage;->sourceId:Ljava/lang/String;

    .line 41
    iput p3, p0, Lcom/amazon/android/webkit/AmazonConsoleMessage;->lineNumber:I

    .line 42
    iput-object p4, p0, Lcom/amazon/android/webkit/AmazonConsoleMessage;->level:Lcom/amazon/android/webkit/AmazonConsoleMessage$MessageLevel;

    .line 44
    return-void
.end method


# virtual methods
.method public message()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonConsoleMessage;->message:Ljava/lang/String;

    return-object v0
.end method
