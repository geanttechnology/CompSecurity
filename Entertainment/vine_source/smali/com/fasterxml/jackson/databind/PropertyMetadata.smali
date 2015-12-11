.class public Lcom/fasterxml/jackson/databind/PropertyMetadata;
.super Ljava/lang/Object;
.source "PropertyMetadata.java"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field public static final STD_OPTIONAL:Lcom/fasterxml/jackson/databind/PropertyMetadata;

.field public static final STD_REQUIRED:Lcom/fasterxml/jackson/databind/PropertyMetadata;

.field public static final STD_REQUIRED_OR_OPTIONAL:Lcom/fasterxml/jackson/databind/PropertyMetadata;

.field private static final serialVersionUID:J = -0x1L


# instance fields
.field protected final _description:Ljava/lang/String;

.field protected final _required:Ljava/lang/Boolean;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 16
    new-instance v0, Lcom/fasterxml/jackson/databind/PropertyMetadata;

    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-direct {v0, v1, v2}, Lcom/fasterxml/jackson/databind/PropertyMetadata;-><init>(Ljava/lang/Boolean;Ljava/lang/String;)V

    sput-object v0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->STD_REQUIRED:Lcom/fasterxml/jackson/databind/PropertyMetadata;

    .line 18
    new-instance v0, Lcom/fasterxml/jackson/databind/PropertyMetadata;

    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-direct {v0, v1, v2}, Lcom/fasterxml/jackson/databind/PropertyMetadata;-><init>(Ljava/lang/Boolean;Ljava/lang/String;)V

    sput-object v0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->STD_OPTIONAL:Lcom/fasterxml/jackson/databind/PropertyMetadata;

    .line 20
    new-instance v0, Lcom/fasterxml/jackson/databind/PropertyMetadata;

    invoke-direct {v0, v2, v2}, Lcom/fasterxml/jackson/databind/PropertyMetadata;-><init>(Ljava/lang/Boolean;Ljava/lang/String;)V

    sput-object v0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->STD_REQUIRED_OR_OPTIONAL:Lcom/fasterxml/jackson/databind/PropertyMetadata;

    return-void
.end method

.method protected constructor <init>(Ljava/lang/Boolean;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->_required:Ljava/lang/Boolean;

    .line 42
    iput-object p2, p0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->_description:Ljava/lang/String;

    .line 43
    return-void
.end method

.method public static construct(ZLjava/lang/String;)Lcom/fasterxml/jackson/databind/PropertyMetadata;
    .locals 1

    .prologue
    .line 46
    if-eqz p0, :cond_1

    sget-object v0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->STD_REQUIRED:Lcom/fasterxml/jackson/databind/PropertyMetadata;

    .line 47
    :goto_0
    if-eqz p1, :cond_0

    .line 48
    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/PropertyMetadata;->withDescription(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/PropertyMetadata;

    move-result-object v0

    .line 50
    :cond_0
    return-object v0

    .line 46
    :cond_1
    sget-object v0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->STD_OPTIONAL:Lcom/fasterxml/jackson/databind/PropertyMetadata;

    goto :goto_0
.end method


# virtual methods
.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->_description:Ljava/lang/String;

    return-object v0
.end method

.method public getRequired()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->_required:Ljava/lang/Boolean;

    return-object v0
.end method

.method public isRequired()Z
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->_required:Ljava/lang/Boolean;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->_required:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected readResolve()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->_description:Ljava/lang/String;

    if-nez v0, :cond_2

    .line 60
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->_required:Ljava/lang/Boolean;

    if-nez v0, :cond_0

    .line 61
    sget-object v0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->STD_REQUIRED_OR_OPTIONAL:Lcom/fasterxml/jackson/databind/PropertyMetadata;

    .line 65
    :goto_0
    return-object v0

    .line 63
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->_required:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    sget-object v0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->STD_REQUIRED:Lcom/fasterxml/jackson/databind/PropertyMetadata;

    goto :goto_0

    :cond_1
    sget-object v0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->STD_OPTIONAL:Lcom/fasterxml/jackson/databind/PropertyMetadata;

    goto :goto_0

    :cond_2
    move-object v0, p0

    .line 65
    goto :goto_0
.end method

.method public withDescription(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/PropertyMetadata;
    .locals 2

    .prologue
    .line 69
    new-instance v0, Lcom/fasterxml/jackson/databind/PropertyMetadata;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->_required:Ljava/lang/Boolean;

    invoke-direct {v0, v1, p1}, Lcom/fasterxml/jackson/databind/PropertyMetadata;-><init>(Ljava/lang/Boolean;Ljava/lang/String;)V

    return-object v0
.end method

.method public withRequired(Ljava/lang/Boolean;)Lcom/fasterxml/jackson/databind/PropertyMetadata;
    .locals 2

    .prologue
    .line 73
    if-nez p1, :cond_1

    .line 74
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->_required:Ljava/lang/Boolean;

    if-nez v0, :cond_2

    .line 82
    :cond_0
    :goto_0
    return-object p0

    .line 78
    :cond_1
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->_required:Ljava/lang/Boolean;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->_required:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eq v0, v1, :cond_0

    .line 82
    :cond_2
    new-instance v0, Lcom/fasterxml/jackson/databind/PropertyMetadata;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/PropertyMetadata;->_description:Ljava/lang/String;

    invoke-direct {v0, p1, v1}, Lcom/fasterxml/jackson/databind/PropertyMetadata;-><init>(Ljava/lang/Boolean;Ljava/lang/String;)V

    move-object p0, v0

    goto :goto_0
.end method
