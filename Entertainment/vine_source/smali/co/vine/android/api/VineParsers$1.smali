.class final Lco/vine/android/api/VineParsers$1;
.super Lco/vine/android/api/VineParsers$RecordListParser;
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
        "Lco/vine/android/api/VineParsers$RecordListParser",
        "<",
        "Lco/vine/android/api/VineUser;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 60
    invoke-direct {p0}, Lco/vine/android/api/VineParsers$RecordListParser;-><init>()V

    return-void
.end method


# virtual methods
.method public parse(Lcom/fasterxml/jackson/core/JsonParser;Landroid/os/Bundle;)Ljava/util/ArrayList;
    .locals 1
    .param p1, "parser"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "extras"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/core/JsonParser;",
            "Landroid/os/Bundle;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 64
    # invokes: Lco/vine/android/api/VineParsers;->parseUsersArray(Lcom/fasterxml/jackson/core/JsonParser;Landroid/os/Bundle;)Ljava/util/ArrayList;
    invoke-static {p1, p2}, Lco/vine/android/api/VineParsers;->access$000(Lcom/fasterxml/jackson/core/JsonParser;Landroid/os/Bundle;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method
