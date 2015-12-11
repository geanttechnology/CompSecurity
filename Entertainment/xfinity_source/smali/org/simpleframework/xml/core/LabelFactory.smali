.class final Lorg/simpleframework/xml/core/LabelFactory;
.super Ljava/lang/Object;
.source "LabelFactory.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 186
    return-void
.end method

.method private static getBuilder(Ljava/lang/annotation/Annotation;)Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;
    .locals 4
    .param p0, "label"    # Ljava/lang/annotation/Annotation;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 145
    instance-of v0, p0, Lorg/simpleframework/xml/Element;

    if-eqz v0, :cond_0

    .line 146
    new-instance v0, Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;

    const-class v1, Lorg/simpleframework/xml/core/ElementLabel;

    const-class v2, Lorg/simpleframework/xml/Element;

    invoke-direct {v0, v1, v2}, Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;-><init>(Ljava/lang/Class;Ljava/lang/Class;)V

    .line 173
    :goto_0
    return-object v0

    .line 148
    :cond_0
    instance-of v0, p0, Lorg/simpleframework/xml/ElementList;

    if-eqz v0, :cond_1

    .line 149
    new-instance v0, Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;

    const-class v1, Lorg/simpleframework/xml/core/ElementListLabel;

    const-class v2, Lorg/simpleframework/xml/ElementList;

    invoke-direct {v0, v1, v2}, Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;-><init>(Ljava/lang/Class;Ljava/lang/Class;)V

    goto :goto_0

    .line 151
    :cond_1
    instance-of v0, p0, Lorg/simpleframework/xml/ElementArray;

    if-eqz v0, :cond_2

    .line 152
    new-instance v0, Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;

    const-class v1, Lorg/simpleframework/xml/core/ElementArrayLabel;

    const-class v2, Lorg/simpleframework/xml/ElementArray;

    invoke-direct {v0, v1, v2}, Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;-><init>(Ljava/lang/Class;Ljava/lang/Class;)V

    goto :goto_0

    .line 154
    :cond_2
    instance-of v0, p0, Lorg/simpleframework/xml/ElementMap;

    if-eqz v0, :cond_3

    .line 155
    new-instance v0, Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;

    const-class v1, Lorg/simpleframework/xml/core/ElementMapLabel;

    const-class v2, Lorg/simpleframework/xml/ElementMap;

    invoke-direct {v0, v1, v2}, Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;-><init>(Ljava/lang/Class;Ljava/lang/Class;)V

    goto :goto_0

    .line 157
    :cond_3
    instance-of v0, p0, Lorg/simpleframework/xml/ElementUnion;

    if-eqz v0, :cond_4

    .line 158
    new-instance v0, Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;

    const-class v1, Lorg/simpleframework/xml/core/ElementUnionLabel;

    const-class v2, Lorg/simpleframework/xml/ElementUnion;

    const-class v3, Lorg/simpleframework/xml/Element;

    invoke-direct {v0, v1, v2, v3}, Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;-><init>(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V

    goto :goto_0

    .line 160
    :cond_4
    instance-of v0, p0, Lorg/simpleframework/xml/ElementListUnion;

    if-eqz v0, :cond_5

    .line 161
    new-instance v0, Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;

    const-class v1, Lorg/simpleframework/xml/core/ElementListUnionLabel;

    const-class v2, Lorg/simpleframework/xml/ElementListUnion;

    const-class v3, Lorg/simpleframework/xml/ElementList;

    invoke-direct {v0, v1, v2, v3}, Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;-><init>(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V

    goto :goto_0

    .line 163
    :cond_5
    instance-of v0, p0, Lorg/simpleframework/xml/ElementMapUnion;

    if-eqz v0, :cond_6

    .line 164
    new-instance v0, Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;

    const-class v1, Lorg/simpleframework/xml/core/ElementMapUnionLabel;

    const-class v2, Lorg/simpleframework/xml/ElementMapUnion;

    const-class v3, Lorg/simpleframework/xml/ElementMap;

    invoke-direct {v0, v1, v2, v3}, Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;-><init>(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V

    goto :goto_0

    .line 166
    :cond_6
    instance-of v0, p0, Lorg/simpleframework/xml/Attribute;

    if-eqz v0, :cond_7

    .line 167
    new-instance v0, Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;

    const-class v1, Lorg/simpleframework/xml/core/AttributeLabel;

    const-class v2, Lorg/simpleframework/xml/Attribute;

    invoke-direct {v0, v1, v2}, Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;-><init>(Ljava/lang/Class;Ljava/lang/Class;)V

    goto :goto_0

    .line 169
    :cond_7
    instance-of v0, p0, Lorg/simpleframework/xml/Version;

    if-eqz v0, :cond_8

    .line 170
    new-instance v0, Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;

    const-class v1, Lorg/simpleframework/xml/core/VersionLabel;

    const-class v2, Lorg/simpleframework/xml/Version;

    invoke-direct {v0, v1, v2}, Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;-><init>(Ljava/lang/Class;Ljava/lang/Class;)V

    goto :goto_0

    .line 172
    :cond_8
    instance-of v0, p0, Lorg/simpleframework/xml/Text;

    if-eqz v0, :cond_9

    .line 173
    new-instance v0, Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;

    const-class v1, Lorg/simpleframework/xml/core/TextLabel;

    const-class v2, Lorg/simpleframework/xml/Text;

    invoke-direct {v0, v1, v2}, Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;-><init>(Ljava/lang/Class;Ljava/lang/Class;)V

    goto/16 :goto_0

    .line 175
    :cond_9
    new-instance v0, Lorg/simpleframework/xml/core/PersistenceException;

    const-string v1, "Annotation %s not supported"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p0, v2, v3

    invoke-direct {v0, v1, v2}, Lorg/simpleframework/xml/core/PersistenceException;-><init>(Ljava/lang/String;[Ljava/lang/Object;)V

    throw v0
.end method

.method private static getConstructor(Ljava/lang/annotation/Annotation;)Ljava/lang/reflect/Constructor;
    .locals 3
    .param p0, "label"    # Ljava/lang/annotation/Annotation;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 125
    invoke-static {p0}, Lorg/simpleframework/xml/core/LabelFactory;->getBuilder(Ljava/lang/annotation/Annotation;)Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;

    move-result-object v0

    .line 126
    .local v0, "builder":Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;
    invoke-virtual {v0}, Lorg/simpleframework/xml/core/LabelFactory$LabelBuilder;->getConstructor()Ljava/lang/reflect/Constructor;

    move-result-object v1

    .line 128
    .local v1, "factory":Ljava/lang/reflect/Constructor;
    invoke-virtual {v1}, Ljava/lang/reflect/Constructor;->isAccessible()Z

    move-result v2

    if-nez v2, :cond_0

    .line 129
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/reflect/Constructor;->setAccessible(Z)V

    .line 131
    :cond_0
    return-object v1
.end method

.method public static getInstance(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/stream/Format;)Lorg/simpleframework/xml/core/Label;
    .locals 2
    .param p0, "contact"    # Lorg/simpleframework/xml/core/Contact;
    .param p1, "label"    # Ljava/lang/annotation/Annotation;
    .param p2, "entry"    # Ljava/lang/annotation/Annotation;
    .param p3, "format"    # Lorg/simpleframework/xml/stream/Format;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 83
    invoke-static {p0, p1, p2, p3}, Lorg/simpleframework/xml/core/LabelFactory;->getLabel(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/stream/Format;)Lorg/simpleframework/xml/core/Label;

    move-result-object v0

    .line 85
    .local v0, "value":Lorg/simpleframework/xml/core/Label;
    if-nez v0, :cond_0

    .line 88
    .end local v0    # "value":Lorg/simpleframework/xml/core/Label;
    :goto_0
    return-object v0

    .restart local v0    # "value":Lorg/simpleframework/xml/core/Label;
    :cond_0
    new-instance v1, Lorg/simpleframework/xml/core/CacheLabel;

    invoke-direct {v1, v0}, Lorg/simpleframework/xml/core/CacheLabel;-><init>(Lorg/simpleframework/xml/core/Label;)V

    move-object v0, v1

    goto :goto_0
.end method

.method public static getInstance(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/stream/Format;)Lorg/simpleframework/xml/core/Label;
    .locals 1
    .param p0, "contact"    # Lorg/simpleframework/xml/core/Contact;
    .param p1, "label"    # Ljava/lang/annotation/Annotation;
    .param p2, "format"    # Lorg/simpleframework/xml/stream/Format;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 65
    const/4 v0, 0x0

    invoke-static {p0, p1, v0, p2}, Lorg/simpleframework/xml/core/LabelFactory;->getInstance(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/stream/Format;)Lorg/simpleframework/xml/core/Label;

    move-result-object v0

    return-object v0
.end method

.method private static getLabel(Lorg/simpleframework/xml/core/Contact;Ljava/lang/annotation/Annotation;Ljava/lang/annotation/Annotation;Lorg/simpleframework/xml/stream/Format;)Lorg/simpleframework/xml/core/Label;
    .locals 6
    .param p0, "contact"    # Lorg/simpleframework/xml/core/Contact;
    .param p1, "label"    # Ljava/lang/annotation/Annotation;
    .param p2, "entry"    # Ljava/lang/annotation/Annotation;
    .param p3, "format"    # Lorg/simpleframework/xml/stream/Format;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 106
    invoke-static {p1}, Lorg/simpleframework/xml/core/LabelFactory;->getConstructor(Ljava/lang/annotation/Annotation;)Ljava/lang/reflect/Constructor;

    move-result-object v0

    .line 108
    .local v0, "factory":Ljava/lang/reflect/Constructor;
    if-eqz p2, :cond_0

    .line 109
    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    aput-object p0, v1, v2

    aput-object p1, v1, v3

    aput-object p2, v1, v4

    aput-object p3, v1, v5

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/simpleframework/xml/core/Label;

    .line 111
    :goto_0
    return-object v1

    :cond_0
    new-array v1, v5, [Ljava/lang/Object;

    aput-object p0, v1, v2

    aput-object p1, v1, v3

    aput-object p3, v1, v4

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/simpleframework/xml/core/Label;

    goto :goto_0
.end method
