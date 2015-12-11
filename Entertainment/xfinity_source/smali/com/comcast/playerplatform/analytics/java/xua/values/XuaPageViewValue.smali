.class public Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPageViewValue;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
.source "XuaPageViewValue.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonInclude;
    value = .enum Lcom/fasterxml/jackson/annotation/JsonInclude$Include;->NON_NULL:Lcom/fasterxml/jackson/annotation/JsonInclude$Include;
.end annotation


# instance fields
.field private pageId:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "PAGE_ID"
    .end annotation
.end field

.field private title:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "TITLE"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "pageId"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;

    .prologue
    .line 22
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPageViewValue;->pageId:Ljava/lang/String;

    .line 24
    iput-object p2, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPageViewValue;->title:Ljava/lang/String;

    .line 25
    return-void
.end method


# virtual methods
.method public getPageId()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 29
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPageViewValue;->pageId:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 38
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPageViewValue;->title:Ljava/lang/String;

    return-object v0
.end method

.method public setPageId(Ljava/lang/String;)V
    .locals 0
    .param p1, "pageId"    # Ljava/lang/String;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPageViewValue;->pageId:Ljava/lang/String;

    .line 34
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPageViewValue;->title:Ljava/lang/String;

    .line 43
    return-void
.end method
