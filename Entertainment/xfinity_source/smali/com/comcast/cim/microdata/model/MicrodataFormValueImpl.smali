.class public Lcom/comcast/cim/microdata/model/MicrodataFormValueImpl;
.super Ljava/lang/Object;
.source "MicrodataFormValueImpl.java"

# interfaces
.implements Lcom/comcast/cim/microdata/model/MicrodataFormValue;


# static fields
.field private static final EMPTY_MAP:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final action:Ljava/lang/String;

.field private context:Lcom/comcast/cim/microdata/model/MicrodataContext;

.field private final fieldMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/microdata/model/MicrodataFormField;",
            ">;"
        }
    .end annotation
.end field

.field private final fields:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataFormField;",
            ">;"
        }
    .end annotation
.end field

.field private final method:Lcom/comcast/cim/microdata/http/HttpMethod;

.field private final title:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/microdata/model/MicrodataFormValueImpl;->EMPTY_MAP:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/cim/microdata/http/HttpMethod;Ljava/util/List;)V
    .locals 4
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "action"    # Ljava/lang/String;
    .param p3, "method"    # Lcom/comcast/cim/microdata/http/HttpMethod;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/microdata/http/HttpMethod;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataFormField;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 27
    .local p4, "fields":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataFormField;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    iput-object p1, p0, Lcom/comcast/cim/microdata/model/MicrodataFormValueImpl;->title:Ljava/lang/String;

    .line 29
    iput-object p2, p0, Lcom/comcast/cim/microdata/model/MicrodataFormValueImpl;->action:Ljava/lang/String;

    .line 30
    iput-object p3, p0, Lcom/comcast/cim/microdata/model/MicrodataFormValueImpl;->method:Lcom/comcast/cim/microdata/http/HttpMethod;

    .line 31
    invoke-static {p4}, Lcom/comcast/cim/microdata/util/MicrodataCollectionUtils;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v3

    iput-object v3, p0, Lcom/comcast/cim/microdata/model/MicrodataFormValueImpl;->fields:Ljava/util/List;

    .line 33
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 34
    .local v1, "fieldMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/comcast/cim/microdata/model/MicrodataFormField;>;"
    invoke-interface {p4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/microdata/model/MicrodataFormField;

    .line 35
    .local v0, "field":Lcom/comcast/cim/microdata/model/MicrodataFormField;
    invoke-virtual {v0}, Lcom/comcast/cim/microdata/model/MicrodataFormField;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 37
    .end local v0    # "field":Lcom/comcast/cim/microdata/model/MicrodataFormField;
    :cond_0
    invoke-static {v1}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v3

    iput-object v3, p0, Lcom/comcast/cim/microdata/model/MicrodataFormValueImpl;->fieldMap:Ljava/util/Map;

    .line 38
    return-void
.end method


# virtual methods
.method public getAction()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormValueImpl;->action:Ljava/lang/String;

    return-object v0
.end method

.method public getFields()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/microdata/model/MicrodataFormField;",
            ">;"
        }
    .end annotation

    .prologue
    .line 57
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormValueImpl;->fields:Ljava/util/List;

    return-object v0
.end method

.method public getMethod()Lcom/comcast/cim/microdata/http/HttpMethod;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormValueImpl;->method:Lcom/comcast/cim/microdata/http/HttpMethod;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataFormValueImpl;->title:Ljava/lang/String;

    return-object v0
.end method

.method public setContext(Lcom/comcast/cim/microdata/model/MicrodataContext;)V
    .locals 0
    .param p1, "context"    # Lcom/comcast/cim/microdata/model/MicrodataContext;

    .prologue
    .line 150
    iput-object p1, p0, Lcom/comcast/cim/microdata/model/MicrodataFormValueImpl;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    .line 151
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 141
    new-instance v0, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    invoke-direct {v0, p0}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;-><init>(Ljava/lang/Object;)V

    .line 142
    .local v0, "builder":Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;
    const-string v1, "title"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataFormValueImpl;->title:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 143
    const-string v1, "action"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataFormValueImpl;->action:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 144
    const-string v1, "method"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataFormValueImpl;->method:Lcom/comcast/cim/microdata/http/HttpMethod;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 145
    const-string v1, "fields"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataFormValueImpl;->fields:Ljava/util/List;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 146
    invoke-virtual {v0}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
