.class public Lcom/poshmark/http/JSON/PMJson;
.super Ljava/lang/Object;
.source "PMJson.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/http/JSON/PMJson$1;,
        Lcom/poshmark/http/JSON/PMJson$SingletonHolder;
    }
.end annotation


# instance fields
.field private gson:Lcom/google/gson/Gson;


# direct methods
.method private constructor <init>()V
    .locals 2

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->serializeNulls()Lcom/google/gson/GsonBuilder;

    move-result-object v0

    const/4 v1, 0x0

    new-array v1, v1, [I

    invoke-virtual {v0, v1}, Lcom/google/gson/GsonBuilder;->excludeFieldsWithModifiers([I)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/http/JSON/PMJson;->gson:Lcom/google/gson/Gson;

    .line 24
    return-void
.end method

.method synthetic constructor <init>(Lcom/poshmark/http/JSON/PMJson$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/poshmark/http/JSON/PMJson$1;

    .prologue
    .line 9
    invoke-direct {p0}, Lcom/poshmark/http/JSON/PMJson;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/poshmark/http/JSON/PMJson;
    .locals 1

    .prologue
    .line 28
    # getter for: Lcom/poshmark/http/JSON/PMJson$SingletonHolder;->INSTANCE:Lcom/poshmark/http/JSON/PMJson;
    invoke-static {}, Lcom/poshmark/http/JSON/PMJson$SingletonHolder;->access$000()Lcom/poshmark/http/JSON/PMJson;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public gson()Lcom/google/gson/Gson;
    .locals 1

    .prologue
    .line 15
    iget-object v0, p0, Lcom/poshmark/http/JSON/PMJson;->gson:Lcom/google/gson/Gson;

    return-object v0
.end method
