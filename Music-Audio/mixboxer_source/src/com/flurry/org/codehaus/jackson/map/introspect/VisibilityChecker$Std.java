// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.introspect;

import com.flurry.org.codehaus.jackson.annotate.JsonAutoDetect;
import com.flurry.org.codehaus.jackson.annotate.JsonMethod;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.introspect:
//            VisibilityChecker, AnnotatedMember, AnnotatedField, AnnotatedMethod

public static class _fieldMinLevel
    implements VisibilityChecker
{

    protected static final withVisibility DEFAULT = new <init>((JsonAutoDetect)com/flurry/org/codehaus/jackson/map/introspect/VisibilityChecker$Std.getAnnotation(com/flurry/org/codehaus/jackson/annotate/JsonAutoDetect));
    protected final com.flurry.org.codehaus.jackson.annotate.ity _creatorMinLevel;
    protected final com.flurry.org.codehaus.jackson.annotate.ity _fieldMinLevel;
    protected final com.flurry.org.codehaus.jackson.annotate.ity _getterMinLevel;
    protected final com.flurry.org.codehaus.jackson.annotate.ity _isGetterMinLevel;
    protected final com.flurry.org.codehaus.jackson.annotate.ity _setterMinLevel;

    public static _fieldMinLevel defaultInstance()
    {
        return DEFAULT;
    }

    private static boolean hasMethod(JsonMethod ajsonmethod[], JsonMethod jsonmethod)
    {
        int j = ajsonmethod.length;
        for (int i = 0; i < j; i++)
        {
            JsonMethod jsonmethod1 = ajsonmethod[i];
            if (jsonmethod1 == jsonmethod || jsonmethod1 == JsonMethod.ALL)
            {
                return true;
            }
        }

        return false;
    }

    public boolean isCreatorVisible(AnnotatedMember annotatedmember)
    {
        return isCreatorVisible(annotatedmember.getMember());
    }

    public boolean isCreatorVisible(Member member)
    {
        return _creatorMinLevel.isVisible(member);
    }

    public boolean isFieldVisible(AnnotatedField annotatedfield)
    {
        return isFieldVisible(annotatedfield.getAnnotated());
    }

    public boolean isFieldVisible(Field field)
    {
        return _fieldMinLevel.isVisible(field);
    }

    public boolean isGetterVisible(AnnotatedMethod annotatedmethod)
    {
        return isGetterVisible(annotatedmethod.getAnnotated());
    }

    public boolean isGetterVisible(Method method)
    {
        return _getterMinLevel.isVisible(method);
    }

    public boolean isIsGetterVisible(AnnotatedMethod annotatedmethod)
    {
        return isIsGetterVisible(annotatedmethod.getAnnotated());
    }

    public boolean isIsGetterVisible(Method method)
    {
        return _isGetterMinLevel.isVisible(method);
    }

    public boolean isSetterVisible(AnnotatedMethod annotatedmethod)
    {
        return isSetterVisible(annotatedmethod.getAnnotated());
    }

    public boolean isSetterVisible(Method method)
    {
        return _setterMinLevel.isVisible(method);
    }

    public String toString()
    {
        return (new StringBuilder("[Visibility:")).append(" getter: ").append(_getterMinLevel).append(", isGetter: ").append(_isGetterMinLevel).append(", setter: ").append(_setterMinLevel).append(", creator: ").append(_creatorMinLevel).append(", field: ").append(_fieldMinLevel).append("]").toString();
    }

    public _fieldMinLevel with(com.flurry.org.codehaus.jackson.annotate.ity ity)
    {
        if (ity == com.flurry.org.codehaus.jackson.annotate.ity.DEFAULT)
        {
            return DEFAULT;
        } else
        {
            return new <init>(ity);
        }
    }

    public <init> with(JsonAutoDetect jsonautodetect)
    {
        if (jsonautodetect == null)
        {
            return this;
        }
        JsonMethod ajsonmethod[] = jsonautodetect.value();
        Object obj;
        <init> <init>1;
        if (hasMethod(ajsonmethod, JsonMethod.GETTER))
        {
            obj = jsonautodetect.getterVisibility();
        } else
        {
            obj = com.flurry.org.codehaus.jackson.annotate.ity.NONE;
        }
        <init>1 = withGetterVisibility(((com.flurry.org.codehaus.jackson.annotate.ity) (obj)));
        if (hasMethod(ajsonmethod, JsonMethod.IS_GETTER))
        {
            obj = jsonautodetect.isGetterVisibility();
        } else
        {
            obj = com.flurry.org.codehaus.jackson.annotate.ity.NONE;
        }
        <init>1 = <init>1.withIsGetterVisibility(((com.flurry.org.codehaus.jackson.annotate.ity) (obj)));
        if (hasMethod(ajsonmethod, JsonMethod.SETTER))
        {
            obj = jsonautodetect.setterVisibility();
        } else
        {
            obj = com.flurry.org.codehaus.jackson.annotate.ity.NONE;
        }
        <init>1 = <init>1.withSetterVisibility(((com.flurry.org.codehaus.jackson.annotate.ity) (obj)));
        if (hasMethod(ajsonmethod, JsonMethod.CREATOR))
        {
            obj = jsonautodetect.creatorVisibility();
        } else
        {
            obj = com.flurry.org.codehaus.jackson.annotate.ity.NONE;
        }
        obj = <init>1.withCreatorVisibility(((com.flurry.org.codehaus.jackson.annotate.ity) (obj)));
        if (hasMethod(ajsonmethod, JsonMethod.FIELD))
        {
            jsonautodetect = jsonautodetect.fieldVisibility();
        } else
        {
            jsonautodetect = com.flurry.org.codehaus.jackson.annotate.ity.NONE;
        }
        return ((NE) (obj)).withFieldVisibility(jsonautodetect);
    }

    public volatile VisibilityChecker with(com.flurry.org.codehaus.jackson.annotate.ity ity)
    {
        return with(ity);
    }

    public volatile VisibilityChecker with(JsonAutoDetect jsonautodetect)
    {
        return with(jsonautodetect);
    }

    public with withCreatorVisibility(com.flurry.org.codehaus.jackson.annotate.ity ity)
    {
        com.flurry.org.codehaus.jackson.annotate.ity ity1 = ity;
        if (ity == com.flurry.org.codehaus.jackson.annotate.ity.DEFAULT)
        {
            ity1 = DEFAULT._creatorMinLevel;
        }
        if (_creatorMinLevel == ity1)
        {
            return this;
        } else
        {
            return new <init>(_getterMinLevel, _isGetterMinLevel, _setterMinLevel, ity1, _fieldMinLevel);
        }
    }

    public volatile VisibilityChecker withCreatorVisibility(com.flurry.org.codehaus.jackson.annotate.ity ity)
    {
        return withCreatorVisibility(ity);
    }

    public withCreatorVisibility withFieldVisibility(com.flurry.org.codehaus.jackson.annotate.ity ity)
    {
        com.flurry.org.codehaus.jackson.annotate.ity ity1 = ity;
        if (ity == com.flurry.org.codehaus.jackson.annotate.ity.DEFAULT)
        {
            ity1 = DEFAULT._fieldMinLevel;
        }
        if (_fieldMinLevel == ity1)
        {
            return this;
        } else
        {
            return new <init>(_getterMinLevel, _isGetterMinLevel, _setterMinLevel, _creatorMinLevel, ity1);
        }
    }

    public volatile VisibilityChecker withFieldVisibility(com.flurry.org.codehaus.jackson.annotate.ity ity)
    {
        return withFieldVisibility(ity);
    }

    public withFieldVisibility withGetterVisibility(com.flurry.org.codehaus.jackson.annotate.ity ity)
    {
        com.flurry.org.codehaus.jackson.annotate.ity ity1 = ity;
        if (ity == com.flurry.org.codehaus.jackson.annotate.ity.DEFAULT)
        {
            ity1 = DEFAULT._getterMinLevel;
        }
        if (_getterMinLevel == ity1)
        {
            return this;
        } else
        {
            return new <init>(ity1, _isGetterMinLevel, _setterMinLevel, _creatorMinLevel, _fieldMinLevel);
        }
    }

    public volatile VisibilityChecker withGetterVisibility(com.flurry.org.codehaus.jackson.annotate.ity ity)
    {
        return withGetterVisibility(ity);
    }

    public withGetterVisibility withIsGetterVisibility(com.flurry.org.codehaus.jackson.annotate.ity ity)
    {
        com.flurry.org.codehaus.jackson.annotate.ity ity1 = ity;
        if (ity == com.flurry.org.codehaus.jackson.annotate.ity.DEFAULT)
        {
            ity1 = DEFAULT._isGetterMinLevel;
        }
        if (_isGetterMinLevel == ity1)
        {
            return this;
        } else
        {
            return new <init>(_getterMinLevel, ity1, _setterMinLevel, _creatorMinLevel, _fieldMinLevel);
        }
    }

    public volatile VisibilityChecker withIsGetterVisibility(com.flurry.org.codehaus.jackson.annotate.ity ity)
    {
        return withIsGetterVisibility(ity);
    }

    public withIsGetterVisibility withSetterVisibility(com.flurry.org.codehaus.jackson.annotate.ity ity)
    {
        com.flurry.org.codehaus.jackson.annotate.ity ity1 = ity;
        if (ity == com.flurry.org.codehaus.jackson.annotate.ity.DEFAULT)
        {
            ity1 = DEFAULT._setterMinLevel;
        }
        if (_setterMinLevel == ity1)
        {
            return this;
        } else
        {
            return new <init>(_getterMinLevel, _isGetterMinLevel, ity1, _creatorMinLevel, _fieldMinLevel);
        }
    }

    public volatile VisibilityChecker withSetterVisibility(com.flurry.org.codehaus.jackson.annotate.ity ity)
    {
        return withSetterVisibility(ity);
    }

    public withSetterVisibility withVisibility(JsonMethod jsonmethod, com.flurry.org.codehaus.jackson.annotate.ity ity)
    {
        switch (witchMap.org.codehaus.jackson.annotate.JsonMethod[jsonmethod.ordinal()])
        {
        default:
            return this;

        case 1: // '\001'
            return withGetterVisibility(ity);

        case 2: // '\002'
            return withSetterVisibility(ity);

        case 3: // '\003'
            return withCreatorVisibility(ity);

        case 4: // '\004'
            return withFieldVisibility(ity);

        case 5: // '\005'
            return withIsGetterVisibility(ity);

        case 6: // '\006'
            return with(ity);
        }
    }

    public volatile VisibilityChecker withVisibility(JsonMethod jsonmethod, com.flurry.org.codehaus.jackson.annotate.ity ity)
    {
        return withVisibility(jsonmethod, ity);
    }


    public (com.flurry.org.codehaus.jackson.annotate.ity ity)
    {
        if (ity == com.flurry.org.codehaus.jackson.annotate.ity.DEFAULT)
        {
            _getterMinLevel = DEFAULT._getterMinLevel;
            _isGetterMinLevel = DEFAULT._isGetterMinLevel;
            _setterMinLevel = DEFAULT._setterMinLevel;
            _creatorMinLevel = DEFAULT._creatorMinLevel;
            _fieldMinLevel = DEFAULT._fieldMinLevel;
            return;
        } else
        {
            _getterMinLevel = ity;
            _isGetterMinLevel = ity;
            _setterMinLevel = ity;
            _creatorMinLevel = ity;
            _fieldMinLevel = ity;
            return;
        }
    }

    public _fieldMinLevel(com.flurry.org.codehaus.jackson.annotate.ity ity, com.flurry.org.codehaus.jackson.annotate.ity ity1, com.flurry.org.codehaus.jackson.annotate.ity ity2, com.flurry.org.codehaus.jackson.annotate.ity ity3, com.flurry.org.codehaus.jackson.annotate.ity ity4)
    {
        _getterMinLevel = ity;
        _isGetterMinLevel = ity1;
        _setterMinLevel = ity2;
        _creatorMinLevel = ity3;
        _fieldMinLevel = ity4;
    }

    public _fieldMinLevel(JsonAutoDetect jsonautodetect)
    {
        JsonMethod ajsonmethod[] = jsonautodetect.value();
        com.flurry.org.codehaus.jackson.annotate.ity ity;
        if (hasMethod(ajsonmethod, JsonMethod.GETTER))
        {
            ity = jsonautodetect.getterVisibility();
        } else
        {
            ity = com.flurry.org.codehaus.jackson.annotate.ity.NONE;
        }
        _getterMinLevel = ity;
        if (hasMethod(ajsonmethod, JsonMethod.IS_GETTER))
        {
            ity = jsonautodetect.isGetterVisibility();
        } else
        {
            ity = com.flurry.org.codehaus.jackson.annotate.ity.NONE;
        }
        _isGetterMinLevel = ity;
        if (hasMethod(ajsonmethod, JsonMethod.SETTER))
        {
            ity = jsonautodetect.setterVisibility();
        } else
        {
            ity = com.flurry.org.codehaus.jackson.annotate.ity.NONE;
        }
        _setterMinLevel = ity;
        if (hasMethod(ajsonmethod, JsonMethod.CREATOR))
        {
            ity = jsonautodetect.creatorVisibility();
        } else
        {
            ity = com.flurry.org.codehaus.jackson.annotate.ity.NONE;
        }
        _creatorMinLevel = ity;
        if (hasMethod(ajsonmethod, JsonMethod.FIELD))
        {
            jsonautodetect = jsonautodetect.fieldVisibility();
        } else
        {
            jsonautodetect = com.flurry.org.codehaus.jackson.annotate.ity.NONE;
        }
        _fieldMinLevel = jsonautodetect;
    }
}
