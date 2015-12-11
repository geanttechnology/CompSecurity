.class abstract Lorg/simpleframework/xml/core/TemplateLabel;
.super Ljava/lang/Object;
.source "TemplateLabel.java"

# interfaces
.implements Lorg/simpleframework/xml/core/Label;


# instance fields
.field private final builder:Lorg/simpleframework/xml/core/KeyBuilder;


# direct methods
.method protected constructor <init>()V
    .locals 1

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    new-instance v0, Lorg/simpleframework/xml/core/KeyBuilder;

    invoke-direct {v0, p0}, Lorg/simpleframework/xml/core/KeyBuilder;-><init>(Lorg/simpleframework/xml/core/Label;)V

    iput-object v0, p0, Lorg/simpleframework/xml/core/TemplateLabel;->builder:Lorg/simpleframework/xml/core/KeyBuilder;

    .line 51
    return-void
.end method


# virtual methods
.method public getDependent()Lorg/simpleframework/xml/strategy/Type;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 142
    const/4 v0, 0x0

    return-object v0
.end method

.method public getEntry()Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 131
    const/4 v0, 0x0

    return-object v0
.end method

.method public getKey()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 119
    iget-object v0, p0, Lorg/simpleframework/xml/core/TemplateLabel;->builder:Lorg/simpleframework/xml/core/KeyBuilder;

    invoke-virtual {v0}, Lorg/simpleframework/xml/core/KeyBuilder;->getKey()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getLabel(Ljava/lang/Class;)Lorg/simpleframework/xml/core/Label;
    .locals 0
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 78
    return-object p0
.end method

.method public getNames()[Ljava/lang/String;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 90
    invoke-virtual {p0}, Lorg/simpleframework/xml/core/TemplateLabel;->getPath()Ljava/lang/String;

    move-result-object v1

    .line 91
    .local v1, "path":Ljava/lang/String;
    invoke-virtual {p0}, Lorg/simpleframework/xml/core/TemplateLabel;->getName()Ljava/lang/String;

    move-result-object v0

    .line 93
    .local v0, "name":Ljava/lang/String;
    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    aput-object v1, v2, v3

    const/4 v3, 0x1

    aput-object v0, v2, v3

    return-object v2
.end method

.method public getPaths()[Ljava/lang/String;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 106
    invoke-virtual {p0}, Lorg/simpleframework/xml/core/TemplateLabel;->getPath()Ljava/lang/String;

    move-result-object v0

    .line 108
    .local v0, "path":Ljava/lang/String;
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object v0, v1, v2

    return-object v1
.end method

.method public getType(Ljava/lang/Class;)Lorg/simpleframework/xml/strategy/Type;
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 64
    invoke-virtual {p0}, Lorg/simpleframework/xml/core/TemplateLabel;->getContact()Lorg/simpleframework/xml/core/Contact;

    move-result-object v0

    return-object v0
.end method

.method public isAttribute()Z
    .locals 1

    .prologue
    .line 153
    const/4 v0, 0x0

    return v0
.end method

.method public isCollection()Z
    .locals 1

    .prologue
    .line 166
    const/4 v0, 0x0

    return v0
.end method

.method public isInline()Z
    .locals 1

    .prologue
    .line 179
    const/4 v0, 0x0

    return v0
.end method

.method public isText()Z
    .locals 1

    .prologue
    .line 191
    const/4 v0, 0x0

    return v0
.end method

.method public isUnion()Z
    .locals 1

    .prologue
    .line 202
    const/4 v0, 0x0

    return v0
.end method
