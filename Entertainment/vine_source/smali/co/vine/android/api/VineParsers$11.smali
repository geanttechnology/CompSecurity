.class final Lco/vine/android/api/VineParsers$11;
.super Lco/vine/android/api/VineParsers$RecordParser;
.source "VineParsers.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/api/VineParsers;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lco/vine/android/api/VineParsers$RecordParser",
        "<",
        "Lco/vine/android/api/VineConversation;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 140
    invoke-direct {p0}, Lco/vine/android/api/VineParsers$RecordParser;-><init>()V

    return-void
.end method


# virtual methods
.method public parse(Lcom/fasterxml/jackson/core/JsonParser;Landroid/os/Bundle;)Lco/vine/android/api/VineConversation;
    .locals 1
    .param p1, "parser"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "extras"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 143
    # invokes: Lco/vine/android/api/VineParsers;->parseConversation(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineConversation;
    invoke-static {p1}, Lco/vine/android/api/VineParsers;->access$900(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineConversation;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic parse(Lcom/fasterxml/jackson/core/JsonParser;Landroid/os/Bundle;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "x1"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 140
    invoke-virtual {p0, p1, p2}, Lco/vine/android/api/VineParsers$11;->parse(Lcom/fasterxml/jackson/core/JsonParser;Landroid/os/Bundle;)Lco/vine/android/api/VineConversation;

    move-result-object v0

    return-object v0
.end method
