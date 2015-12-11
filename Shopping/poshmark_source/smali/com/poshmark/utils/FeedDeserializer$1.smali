.class Lcom/poshmark/utils/FeedDeserializer$1;
.super Lcom/google/gson/reflect/TypeToken;
.source "FeedDeserializer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/FeedDeserializer;->createContent(Lcom/google/gson/JsonElement;Lcom/poshmark/data_model/models/FeedItem;Lcom/google/gson/Gson;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/gson/reflect/TypeToken",
        "<",
        "Ljava/util/List",
        "<",
        "Lcom/poshmark/data_model/models/ListingSocial;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/FeedDeserializer;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/FeedDeserializer;)V
    .locals 0

    .prologue
    .line 114
    iput-object p1, p0, Lcom/poshmark/utils/FeedDeserializer$1;->this$0:Lcom/poshmark/utils/FeedDeserializer;

    invoke-direct {p0}, Lcom/google/gson/reflect/TypeToken;-><init>()V

    return-void
.end method
